package com.meixiang.beauty.modules;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.ResponseDTO;
import com.meixiang.beauty.common.dto.elder.RelativeElderDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.SysPractitionerUserDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.UserInfoDTO;
import com.meixiang.beauty.modules.health.service.HealthArchive;
import com.meixiang.beauty.modules.my.service.SysPractitionerUserService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.entity.User;
import com.meixiang.beauty.sys.service.EasemobService;
import com.meixiang.beauty.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 关于账户管理
 * @author 张博
 * @date 2017-5-5
 */
@Controller
@RequestMapping(value = "")
public class InfoController {

    private static Lock lock = new ReentrantLock();

    private static ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

    @Autowired
    private UserService userService;

    @Autowired
    private SysPractitionerUserService sysPractitionerUserService;

    @Autowired
    private EasemobService easemobService;

    @Autowired
    HealthArchive healthArchive;


    /**
     * 修改用户头像;
     *
     *
     */
    @RequestMapping(value = "laoyou/updateHeadImage", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateHeadImage(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request) {
        User user=UserService.getUser(request);
        user.setPhoto(userInfoDto.getHeadImage());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }

    /**
     * 修改用户姓名
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserName", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserName(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request)throws Exception {
        User user=UserService.getUser(request);
        user.setId(user.getId());
        user.setName(userInfoDto.getName());
        if(userInfoDto.getAge()!=null&&!userInfoDto.getAge().equals("")){
            user.setAge(userInfoDto.getAge());
        }
        if(userInfoDto.getGender()!=null&&!userInfoDto.getGender().equals("")){
            user.setGender(userInfoDto.getGender());
        }
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            userService.updateRedisUser(request);
            //if(easemobService.updateEasemobUserNickName(user.getSysPractitionerUser().getEasemobID(),userInfoDto.getName())){
                responseDto.setResult(StatusConstant.SUCCESS);
                responseDto.setErrorInfo("");
                return responseDto;
            //}else{
            //   responseDto.setResult(StatusConstant.FAILURE);
            //    responseDto.setErrorInfo("");
            //    return responseDto;
            //}
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }


    /**
     * 修改用户性别
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserGender", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserGender(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request) {
        User user=UserService.getUser(request);
        user.setGender(userInfoDto.getGender());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }


    /**
     * 修改用户地区
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserArea", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserArea(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request) {
        User user=UserService.getUser(request);
        user.setArea(userInfoDto.getArea());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }

    /**
     * 修改用户科室
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserDepartment", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserDepartment(@RequestBody UserInfoDTO userInfoDto,HttpServletRequest request) {
        User user=UserService.getUser(request);
        SysPractitionerUserDTO sysPractitionerUser=user.getSysPractitionerUser();
        sysPractitionerUser.setDepartment(userInfoDto.getDepartment());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (sysPractitionerUserService.updateSysPractitionerUser(sysPractitionerUser)>0){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }


    /**
     * 修改用户职称
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserTitle", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserTitle(@RequestBody UserInfoDTO userInfoDto,HttpServletRequest request) {
        User user=UserService.getUser(request);
        SysPractitionerUserDTO sysPractitionerUser=user.getSysPractitionerUser();
        sysPractitionerUser.setTitle(userInfoDto.getTitle());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (sysPractitionerUserService.updateSysPractitionerUser(sysPractitionerUser)>0){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }

    /**
     * 修改用户医院
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserHospitalName", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserHospitalName(@RequestBody UserInfoDTO userInfoDto,HttpServletRequest request) {
        User user=UserService.getUser(request);
        SysPractitionerUserDTO sysPractitionerUser=user.getSysPractitionerUser();
        sysPractitionerUser.setHospitalName(userInfoDto.getHospitalName());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (sysPractitionerUserService.updateSysPractitionerUser(sysPractitionerUser)>0){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("成功");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("失败");
            return responseDto;
        }
    }

    /**
     * 获取用户信息
     *
     *
     */
    @RequestMapping(value = "laoyou/getUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> getUserInfo(HttpServletRequest request) {
        ResponseDTO responseDto = new ResponseDTO();
        User user = UserService.getUser(request);
        responseDto.setResponseData(user);
        responseDto.setResult(StatusConstant.SUCCESS);
        return responseDto;
    }

    /**
     * 获取用户所有的亲友圈中亲友的信息
     * @return
     */
    @RequestMapping(value = "laoyou/relativeElderInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<RelativeElderDTO>> relativeElderInfo(HttpServletRequest request) {

        ResponseDTO<List<RelativeElderDTO>> responseDTO = new ResponseDTO<>();

        /**
         *
         * 获取用户所有的亲友圈中亲友的信息，将用户的亲友圈的亲友信息放入RelativeElderDTO中
         *
         * */
        List<RelativeElderDTO> elderInfoList = new ArrayList<>();
        responseDTO.setResponseData(healthArchive.getRelativeList(UserService.getUser(request)));
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

}