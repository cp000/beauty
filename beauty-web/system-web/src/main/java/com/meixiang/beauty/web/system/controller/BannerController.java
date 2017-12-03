package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.BannerDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.modules.system.api.BannerService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "system")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	/**
	 * 添加 Banner 图
	 *
	 */
	@RequestMapping(value = "addBanner", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO<BannerDTO> addBanner(@RequestBody BannerDTO bannerDTO, HttpServletRequest request) {
		ResponseDTO responseDto=new ResponseDTO<>();
		if (bannerService.addBanner(bannerDTO)>0){
			responseDto.setResult(StatusConstant.SUCCESS);
			responseDto.setErrorInfo("添加成功");
			return responseDto;
		}else {
			responseDto.setResult(StatusConstant.FAILURE);
			responseDto.setErrorInfo("添加失败");
			return responseDto;
		}
	}

	/**
	 * 获取 Banner 图
	 *
			 */
	@RequestMapping(value = "getBannerList", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO<List<BannerDTO>> getBanner() {
		ResponseDTO responseDto=new ResponseDTO<>();
		List<BannerDTO> list = bannerService.getBannerList();
		if(list.size()>0){
			responseDto.setResponseData(list);
			responseDto.setResult(StatusConstant.SUCCESS);
		}else{
			responseDto.setResult(StatusConstant.FAILURE);
		}
		return responseDto;
	}


}
