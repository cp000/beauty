package com.meixiang.beauty.modules.product.impl;

import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.product.ProductDTO;
import com.meixiang.beauty.common.dto.product.TrainingProductDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.modules.product.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
@Transactional(readOnly = false)
public class ProductServiceImpl implements ProductService {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public List<ProductDTO> findProductList(PageParamDTO pageParamDTO) {
        return null;
    }

    @Override
    public OfflineProductDTO getOfflineProductDetailById(String productId) {
        return null;
    }

    @Override
    public TrainingProductDTO getTrainingProductDetailById(String productId) {
        return null;
    }
}
