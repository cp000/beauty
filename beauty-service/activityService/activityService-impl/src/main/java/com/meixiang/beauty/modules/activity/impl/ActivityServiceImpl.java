package com.meixiang.beauty.modules.activity.impl;

import com.alibaba.fastjson.JSON;
import com.meixiang.beauty.common.dto.activity.ActivityDTO;
import com.meixiang.beauty.common.dto.activity.ActivityDiscussDTO;
import com.meixiang.beauty.common.dto.activity.ActivityEasemobGroupInfo;
import com.meixiang.beauty.common.dto.activity.AttendedActivityDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.SysElderUserDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.SysHospitalUserDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.modules.activity.DTO.ActivityEasemobGroupInfoDTO;
import com.meixiang.beauty.modules.activity.DTO.ActivityEasemobGroupUserDTO;
import com.meixiang.beauty.modules.activity.dao.*;
import com.meixiang.beauty.modules.activity.entity.*;
import com.meixiang.beauty.modules.activity.service.ActivityService;
import com.meixiang.beauty.sys.dao.SysElderUserDao;
import com.meixiang.beauty.sys.dao.SysHospitalUserDao;
import com.meixiang.beauty.sys.dao.UserDao;
import com.meixiang.beauty.sys.entity.User;
import com.meixiang.beauty.sys.service.EasemobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
@Transactional(readOnly = false)
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private ActivityUserDao activityUserDao;

    @Autowired
    private ActivityDiscussDao activityDiscussDao;

    @Autowired
    private ActivityEasemobGroupDao activityEasemobGroupDao;

    @Autowired
    private SysHospitalUserDao sysHospitalUserDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ActivityFavoriteDao activityFavoriteDao;


    @Autowired
    private SysElderUserDao sysElderUserDao;


    @Override
    public ActivityDTO getActivity(String elderID) {
        return activityDao.getActivityList(elderID,null).get(0);
    }

    @Override
    public List<ActivityDTO> getActivityList(String elderID, String pageNo,String activityType) {
        List<ActivityDTO> result = activityDao.getMyActivityListByElderID(elderID,Integer.parseInt(pageNo)*10,activityType);
        return result;
    }


    @Override
    public Integer addActivity(Activity activity, User user) {
        activity.setSysUserID(user.getId());
        if(user.getSysElderUserDTO()!=null){
            activity.setUserType("0");
        }else{
            activity.setUserType("1");
        }
        activityDao.addActivity(activity);
        return activity.getId();
    }

    @Override
    public List<AttendedActivityDTO> getActivityByElderUser(String elderID) {
        List<AttendedActivityDTO> list = activityDao.getActivityListByElderID(elderID);
        List<AttendedActivityDTO> result = new ArrayList<>();
        for (AttendedActivityDTO a : list) {
            a.setActivityAttendedNum(activityUserDao.getActivityCountByID(a.getActivityId(), null).toString());
            result.add(a);
        }
        return result;
    }

    @Override
    public List<ActivityDiscussDTO> getActivityDiscuss(String id, Integer page) {
        return activityDiscussDao.getActivityDiscussList(id,page);
    }

    @Override
    public Integer addActivityDiscuss(ActivityDiscussDTO activityDiscussDTO) {
        ActivityDiscuss activityDiscuss = new ActivityDiscuss();
        activityDiscuss.setContent(activityDiscussDTO.getDiscussContent());
        activityDiscuss.setSysUserElderID(activityDiscussDTO.getElderId());
        activityDiscuss.setActivityID(activityDiscussDTO.getActivityId());
        return activityDiscussDao.addActivityDiscuss(activityDiscuss);
    }

    @Override
    public Integer updateActivtyStatus() {
        List<Activity> list = activityDao.getActivityListByTask();
        for (Activity a : list) {
            String status = "ongoing";
            if (a.getStatus().equals("ongoing")) {
                status = "end";
            }
            activityDao.updateActivityStatus(status, a.getId().toString());
        }
        return 0;
    }

    @Override
    public Integer getActivityAttendStatus(String activityID, String elderID) {
        return activityUserDao.getActivityCountByID(activityID, elderID);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addActivityUser(String activityID, List<String> elderIDs) {
        ActivityUser activityUser = new ActivityUser();
        activityUser.setActivityID(activityID);
        ActivityDTO activity = activityDao.getActivityList(activityID,null).get(0);
        Integer nums=activityUserDao.getActivityCountByID(activityID, null);
        if(nums!=0&&nums==activity.getPeopleNum()){
            return "max";
        }
        boolean ifGroup=activity.getActivityEasemobGroupID()!=null && !activity.getActivityEasemobGroupID().equals("");
        for (String eID : elderIDs) {
            activityUser.setSysElderUserID(eID);
            activityUserDao.addActivityUser(activityUser);

            //将用户加入群组
            if(ifGroup){
                String elderEasemobID = sysElderUserDao.getSysElderUser(eID).getEasemobID();
                ActivityEasemobGroup activityEasemobGroup = activityEasemobGroupDao.searchActivityEasemobGroupByGroupID(activity.getActivityEasemobGroupID());
                boolean a = true;//EasemobService.joinEasemobGroup(activityEasemobGroup.getGroupId(),elderEasemobID);
                if(a){
                    activityEasemobGroup.setMembers(activityEasemobGroup.getMembers().equals("")?elderEasemobID:activityEasemobGroup.getMembers()+","+elderEasemobID);
                    activityEasemobGroupDao.updateActivityEasemobGroup(activityEasemobGroup);
                }
            }

        }
        activity = activityDao.getActivityList(activityID,null).get(0);
        return activity.getActivityEasemobGroupID();
    }


    @Override
    public void createActivityEasemobGroup(String activityID, User user) {
        ActivityDTO activity = activityDao.getActivityList(activityID,null).get(0);
        String groupName = activity.getActivityName();
        String desc = activity.getActivityDetailInfo();
        String owner="";
        if(user.getSysElderUserDTO()!=null) {
            owner = user.getSysElderUserDTO().getEasemobID();
        }else{
            owner=user.getSysHospitalUserDTO().getEasemobID();
        }
        String result = EasemobService.createEasemobGroup(groupName, desc, owner, owner);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(result.split(">>>>")[1]);
        ActivityEasemobGroup activityEasemobGroup = new ActivityEasemobGroup();
        activityEasemobGroup.setGroupId(((Map<String, Object>) JSON.parse(map.get("data").toString())).get("groupid").toString());
        activityEasemobGroup.setGroupName(groupName);
        activityEasemobGroup.setOwner(owner);
        activityEasemobGroup.setMembers(owner);
        activityEasemobGroup.setDesc(activity.getActivityDetailInfo());
        Integer res = activityEasemobGroupDao.addActivityEasemobGroup(activityEasemobGroup);
        activityDao.updateActivityEasemobGroup(activityID,activityEasemobGroup.getId().toString());
    }



    @Override
    public void joinActivityEasemobGroup(String activityID, User user) {
        ActivityDTO activity = activityDao.getActivityList(activityID,null).get(0);
        String elderEasemobID=user.getSysElderUserDTO().getEasemobID();
//        ActivityEasemobGroup activityEasemobGroup=activityEasemobGroupDao.searchActivityEasemobGroupByID(activity.getActivityEasemobGroupID());
        boolean a=EasemobService.joinEasemobGroup(activity.getActivityEasemobGroupID(),elderEasemobID);
        if(a){
            ActivityEasemobGroup activityEasemobGroup=new ActivityEasemobGroup();
            activityEasemobGroup.setMembers(activityEasemobGroup.getMembers().equals("")?elderEasemobID:activityEasemobGroup.getMembers()+","+elderEasemobID);
            activityEasemobGroupDao.updateActivityEasemobGroup(activityEasemobGroup);
        }
    }

    @Override
    public List<ActivityEasemobGroupInfo> getActivityEasemobGroupUserList(String activityID) {
        ActivityDTO activity = activityDao.getActivityList(activityID,null).get(0);
        ActivityEasemobGroup activityEasemobGroup=activityEasemobGroupDao.searchActivityEasemobGroupByID(activity.getActivityEasemobGroupID());
        String[] memeber=activityEasemobGroup.getMembers().split(",");
        List<ActivityEasemobGroupInfo> list=new ArrayList<>();
        for (String m:memeber) {
            SysElderUserDTO sysElderUserDTO=sysElderUserDao.getSysElderUserByEasemobID(m);
            User user=userDao.get(sysElderUserDTO.getSysUserID());
            ActivityEasemobGroupInfo activityEasemobGroupInfo=new ActivityEasemobGroupInfo();
            activityEasemobGroupInfo.setUserName(user.getName());
            activityEasemobGroupInfo.setUserPhoto(user.getPhoto());
            list.add(activityEasemobGroupInfo);
        }
        return list;
    }

    @Override
    public List<ActivityDTO> getActivityListBySearch(String search) {
        return activityDao.getActivityList(null,search);
    }

    @Override
    public void addActivityFavorite(String activityID,String sysElderUserID) {
        ActivityFavorite activityFavorite=new ActivityFavorite();
        activityFavorite.setActivityID(activityID);
        activityFavoriteDao.addActivityFavorite(activityFavorite);
    }

    @Override
    public void delActivityFavorite(String activityID,String sysElderUserID) {
        ActivityFavorite activityFavorite=new ActivityFavorite();
        activityFavorite.setActivityID(activityID);
        activityFavoriteDao.addActivityFavorite(activityFavorite);
    }

    @Override
    public List<ActivityDTO> activityListByFirstPage(String hospitalID) {
        List<ActivityDTO> list=activityDao.getMyHospitalActivityListByHospitalID(hospitalID);
        if(list.size()==0){
            list=activityDao.getMyActivityListByElderID(null,2,null);
        }else if(list.size()==1){
            ActivityDTO activityDTO=activityDao.getMyActivityListByElderID(null,2,null).get(1);
            list.add(activityDTO);
        }
        return list;
    }

    @Override
    public List<ActivityDTO> getMyFavoriteActivityList(String sysElderUserID) {
        return activityDao.getMyFavoriteActivityList(sysElderUserID);
    }

    @Override
    public List<ActivityEasemobGroup> getUserActivityGroupInfo(String elderEasemobID) {

        return activityEasemobGroupDao.getUserActivityEasemobGroupList(elderEasemobID);
    }

    @Override
    public List<ActivityEasemobGroup> getUserActivityEasemobGroupList(String elderEasemobID) {
        return activityEasemobGroupDao.getUserActivityEasemobGroupList(elderEasemobID);
    }

    @Override
    public ActivityEasemobGroupInfoDTO getActivityEasemobGroupUsers(String groupID) {
        ActivityEasemobGroup activityEasemobGroup=activityEasemobGroupDao.searchActivityEasemobGroupByGroupID(groupID);
        List<ActivityEasemobGroupUserDTO> list=new ArrayList<>();
        String[] members=activityEasemobGroup.getMembers().split(",");
        for (String m:members) {
            SysElderUserDTO sysElderUserDTO = sysElderUserDao.getSysElderUserByEasemobID(m);
            String sysUserID="";
            if(sysElderUserDTO==null){
                SysHospitalUserDTO sysHospitalUserDTO=sysHospitalUserDao.getSysHospitalUserByEasemobID(activityEasemobGroup.getOwner());
                sysUserID=sysHospitalUserDTO.getSysUserID();
            }else {
                sysUserID = sysElderUserDTO.getSysUserID();
            }
            User user = userDao.get(sysUserID);
            ActivityEasemobGroupUserDTO activityEasemobGroupUserDTO=new ActivityEasemobGroupUserDTO();
            activityEasemobGroupUserDTO.setSysUserID(sysUserID);
            activityEasemobGroupUserDTO.setName(user.getName());
            activityEasemobGroupUserDTO.setPhoto(user.getPhoto());
            list.add(activityEasemobGroupUserDTO);
        }
        ActivityEasemobGroupInfoDTO activityEasemobGroupInfoDTO=new ActivityEasemobGroupInfoDTO();
        activityEasemobGroupInfoDTO.setActivityID(activityDao.getActivityByGroupID(activityEasemobGroup.getId().toString()).getId().toString());
        activityEasemobGroupInfoDTO.setActivityEasemobGroupUserDTO(list);
        return activityEasemobGroupInfoDTO;
    }

    @Override
    public void sendReservationMessage() {
    }

    @Override
    public void insertIP(String ip) {
        activityDao.insertIP(ip);
    }

    @Override
    public Page activityListByBackEnd(String hospitalID, String status, Integer pageNo, Integer pageSize, String searchValue, String startDate, String endDate) {
        Page page=new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        return activityDao.getActivityListByBackEnd(hospitalID,status,searchValue,startDate,endDate,page);
    }

    @Override
    public List<ActivityUser> activityUserListByBackEnd(String activityID) {
        return activityUserDao.getActivityUserList(activityID);
    }

}
