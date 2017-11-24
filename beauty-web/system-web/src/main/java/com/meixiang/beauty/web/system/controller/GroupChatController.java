/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.ResponseDTO;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.product.service.ActivityService;
import com.meixiang.beauty.modules.system.HealthArchive;
import com.meixiang.beauty.modules.system.HealthServicePackage;
import com.meixiang.beauty.modules.system.MedicationPlanService;
import com.meixiang.beauty.modules.account.HealthDataService;
import com.meixiang.beauty.sys.service.EasemobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 工具 Controller
 *
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
@RequestMapping(value = "laoyou")
public class GroupChatController extends BaseController {

    @Autowired
    private HealthServicePackage healthServicePackage;

    @Autowired
    private HealthArchive healthArchive;

    @Autowired
    private HealthDataService healthDataService;

    @Autowired
    private MedicationPlanService medicationPlanService;

    @Autowired
    private EasemobService easemobService;

    @Autowired
    private ActivityService activityService;

    /**
     * 获取消息模板数据
     * input menuType,获取菜单的类型
     * <p>
     * output HashMap<String,Object></>
     * key为菜单名称
     * value为菜单的H5　url
     */
    @RequestMapping(value = "/groupChatData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<Object> menuData(@RequestParam(required = true) String messageType,
                                 @RequestParam(required = true) String id) {
        ResponseDTO<Object> responseDto = new ResponseDTO<>();

        try {
            if (messageType.equals("chatType1")) {
                responseDto.setResponseData(healthServicePackage.getOnGoingHealthServicePackage(id));
            } else if (messageType.equals("chatType2")) {
                responseDto.setResponseData(healthArchive.getPhysicalExamination(id));
            } else if (messageType.equals("chatType3")) {

            } else if (messageType.equals("chatType4") || messageType.equals("chatType5")) {
                responseDto.setResponseData(healthDataService.getSingleHealthDataFromMongo(id));
            } else if (messageType.equals("chatType6")) {
                responseDto.setResponseData(healthDataService.getSingleTestReportFromMongo(id));
            } else if (messageType.equals("chatType7")) {
                responseDto.setResponseData(healthDataService.getSingleTreatmentRecordFromMongo(id));
            } else if (messageType.equals("chatType8")) {
                responseDto.setResponseData(medicationPlanService.getMedicationPlanTimingByID(id));
            }
            responseDto.setResult(StatusConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDto.setResult(StatusConstant.FAILURE);
        }
        return responseDto;
    }

    @RequestMapping(value = "/getEasemobGroupByGroupID", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ResponseDTO<Object> getEasemobGroupByGroupID(@RequestParam(value = "groupID") String groupID) {
        ResponseDTO<Object> responseDto = new ResponseDTO<>();
        try {
            responseDto.setResponseData(easemobService.getEasemobGroupByGroupID(groupID));
        } catch (Exception e) {
            try {
                responseDto.setResponseData(activityService.getActivityEasemobGroupUsers(groupID));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        responseDto.setResult(StatusConstant.SUCCESS);
        return responseDto;
    }


    @RequestMapping(value = "/getDoctorInfoByID", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ResponseDTO<Object> getDoctorInfoByID(@RequestParam(value = "id") String id) {
        ResponseDTO<Object> responseDto = new ResponseDTO<>();
        responseDto.setResponseData(easemobService.getDoctorInfoByID(id));
        responseDto.setResult(StatusConstant.SUCCESS);
        return responseDto;
    }

}
