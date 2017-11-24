package com.meixiang.beauty.modules.system.impl;


import com.meixiang.beauty.common.dto.elder.RelativeElderDTO;
import com.meixiang.beauty.common.dto.practitioner.healthArchive.BasicInfoDTO;
import com.meixiang.beauty.modules.system.RelativeElderService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by zbm84 on 2017/8/3.
 */
public class RelativeElderServiceImpl implements RelativeElderService {

    private MongoTemplate mongoTemplate;

    @Override
    public List<RelativeElderDTO> relativeElderInfo(String elderID) {
        Query query=new Query().addCriteria(Criteria.where("elderId").is(elderID));
        BasicInfoDTO basicInfoDTO=mongoTemplate.findOne(query, BasicInfoDTO.class,"healthArchive_basicInfo");

        return null;
    }

}
