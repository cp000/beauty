package com.meixiang.beauty.web.product.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.modules.product.api.ProductService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 关于账户管理
 * @author frank
 * @date 2015-10-14
 */
@Controller
@RequestMapping(value = "product")
public class ProductController {

	private static Lock lock = new ReentrantLock();

	@Autowired
	private ProductService productService;

	/**
	 * 获取商城首页的产品的列表，每次获取6条产品记录，前端下拉时记载更多的6条，此处不包括产品详情
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "productList", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO<List<ProductDTO>> productList(@RequestBody PageParamDTO<String> pageParamDTO) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<List<ProductDTO>> responseDTO = new ResponseDTO<>();
		//pageParamDTO.getRequestData()为String类型，为"all"的时候表示任意类型，"training"为培训课程,"offline"为线下产品
		List<ProductDTO> productDTOList = productService.findProductList(pageParamDTO);
		responseDTO.setResponseData(productDTOList);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}


	/**
	 * 获取线下商品的详细信息
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "offlineProductDetail", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO<OfflineProductDTO> offlineProductDetail(@RequestParam String productId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<OfflineProductDTO> responseDTO = new ResponseDTO<>();
		OfflineProductDTO offlineProductDTO = productService.getOfflineProductDetailById(productId);
		responseDTO.setResponseData(offlineProductDTO);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}

	/**
	 * 获取培训商品的详细信息
	 *
	 * input PageParamDto
	 *
	 * output ResponseDTO<List<ProductDTO>>
	 *
	 */
	@RequestMapping(value = "trainingProductDetail", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO<TrainingProductDTO> trainingProductDetail(@RequestParam String productId) {
		DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
		ResponseDTO<TrainingProductDTO> responseDTO = new ResponseDTO<>();
		TrainingProductDTO trainingProductDTO = productService.getTrainingProductDetailById(productId);
		responseDTO.setResponseData(trainingProductDTO);
		responseDTO.setResult(StatusConstant.SUCCESS);
		return responseDTO;
	}

}
