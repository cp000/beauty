package com.meixiang.beauty.web.transaction.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.UserOrderAddressDTO;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * 获取用户购物车中的信息
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "buyCart", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<BusinessOrderDTO>> buyCart(@RequestParam String userId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<List<BusinessOrderDTO>> responseDTO = new ResponseDTO<>();
        List<BusinessOrderDTO> businessOrderDTOList = transactionService.getUserUnPayOrderInBuyCart(userId);
        responseDTO.setResponseData(businessOrderDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 获取用户购物车中的信息
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "createBusinessOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO createBusinessOrder(@RequestBody BusinessOrderDTO businessOrderDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            transactionService.createBusinessOrder(businessOrderDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("订单创建成功");

        }catch (Exception e){
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("订单创建失败");
            e.printStackTrace();
        }
        return responseDTO;
    }



    /**
     * 获取用户购物车中未支付订单数量
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "buyCartUnPayNum", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<String> buyCartUnPayNum(@RequestParam String userId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        String buyCartUnPayNum = transactionService.getUserUnPayOrderNum(userId);
        responseDTO.setResponseData(buyCartUnPayNum);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 增加用户购物车中，某个订单的产品购买数量
     *
     * input userId,businessOrderId,operateType
     * operateType有add和del两种操作模式
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "updateProductNumInBusinessOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO updateProductNumInBusinessOrder(@RequestParam String userId,
                                                @RequestParam String businessOrderId,
                                                @RequestParam String operateType) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            transactionService.updateProductNumInBusinessOrder(userId,businessOrderId,operateType);
            responseDTO.setErrorInfo("更新订单中的产品数量成功");
            responseDTO.setResult(StatusConstant.SUCCESS);
        }catch (Exception e){
            responseDTO.setErrorInfo("更新订单中的产品数量失败");
            responseDTO.setResult(StatusConstant.FAILURE);
            e.printStackTrace();
        }
        return responseDTO;
    }


    /**
     * 更改某个订单的状态，可以修改为未支付、待支付等状态
     * 0表示未支付，1表示待支付，2表示已支付，3表示订单失效
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "updateBusinessOrderStatus", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<String> updateBusinessOrderStatus(@RequestBody List<BusinessOrderDTO> businessOrderDTOList) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        try
        {
            transactionService.updateBusinessOrderStatus(businessOrderDTOList);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 根据订单状态获取订单列表
     * 0表示未支付，1表示待支付，
     * 2表示已支付且未收货，3表示已支付且已收货，
     * 4表示订单失效
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "businessOrderList", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<BusinessOrderDTO>> businessOrderList(@RequestParam String userId, @RequestParam String status) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<List<BusinessOrderDTO>> responseDTO = new ResponseDTO<>();
        List<BusinessOrderDTO> businessOrderDTOList =  transactionService.getBusinessOrderList(userId,status);
        responseDTO.setResponseData(businessOrderDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "userAddressList", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<UserOrderAddressDTO>> userAddressList(@RequestParam String userId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<List<UserOrderAddressDTO>> responseDTO = new ResponseDTO<>();
        List<UserOrderAddressDTO> userOrderAddressDTOList =  transactionService.getUserAddressList(userId);
        responseDTO.setResponseData(userOrderAddressDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "addUserAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO addUserAddress(@RequestBody UserOrderAddressDTO userOrderAddressDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            transactionService.addUserAddress(userOrderAddressDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("添加用户地址成功");
        }catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("添加用户地址失败");
        }
        return responseDTO;
    }

    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO
     *
     */
    @RequestMapping(value = "updateUserAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO updateUserAddress(@RequestBody UserOrderAddressDTO userOrderAddressDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            transactionService.updateUserAddress(userOrderAddressDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("更新用户收货地址成功");
        }catch (Exception e){
            responseDTO.setErrorInfo("更新用户收货地址失败");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }


}
