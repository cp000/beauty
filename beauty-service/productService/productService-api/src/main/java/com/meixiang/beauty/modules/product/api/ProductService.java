package com.meixiang.beauty.modules.product.api;

import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
public interface ProductService {

    List<ProductDTO<OfflineProductDTO>> findProductList(PageParamDTO pageParamDTO);

    OfflineProductDTO getOfflineProductDetailById(String productId);

    TrainingProductDTO getTrainingProductDetailById(String productId);

    void addOfflineProduct(ProductDTO<OfflineProductDTO> productDTO);

    void delOfflineProduct(String productId);

    void updateOfflineProduct(ProductDTO<OfflineProductDTO> productDTO);

    void updateTrainingProductDetail(TrainingProductDTO trainingProductDTO);
}
