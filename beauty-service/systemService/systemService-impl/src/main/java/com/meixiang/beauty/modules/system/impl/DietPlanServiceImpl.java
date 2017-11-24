package com.meixiang.beauty.modules.system.impl;

import com.meixiang.beauty.common.dto.practitioner.healthService.DietPlanDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.modules.system.DietPlanService;
import com.meixiang.beauty.sys.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by zbm84 on 2017/5/27.
 */
@Service
@Transactional(readOnly = false)
public class DietPlanServiceImpl implements DietPlanService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<DietPlanDTO> getAllDietPlan(String userid) {
        Query query=new Query().addCriteria(Criteria.where("elderUserID").is(userid));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"createDate")));
        return mongoTemplate.findAll(DietPlanDTO.class,"DietPlan");
    }

    @Override
    public Integer insertDietPlan(DietPlanDTO dietPlanDTO) {
        dietPlanDTO.setId(UUIDUtil.getUUID());
        dietPlanDTO.setCreateDate(DateUtils.getDateTime());
        try {
            mongoTemplate.insert(dietPlanDTO,"DietPlan");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public DietPlanDTO getDietPlan(String dietPlanID) {
        Query query=new Query().addCriteria(Criteria.where("_id").is(dietPlanID));
        return mongoTemplate.findOne(query,DietPlanDTO.class,"DietPlan");
    }

    @Override
    public List<DietPlanDTO> getAllDietPlanByDate(DietPlanDTO dietPlanDTO) {
        Query query=new Query().addCriteria(Criteria.where("elderUserID").is(dietPlanDTO.getElderUserID()))
                .addCriteria(Criteria.where("createDate").gte(dietPlanDTO.getStartDate()).andOperator(Criteria.where("createDate").lte(dietPlanDTO.getEndDate()+" 23:59")));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createDate")));
        List<DietPlanDTO> list=mongoTemplate.find(query,DietPlanDTO.class,"DietPlan");
        for (DietPlanDTO dietPlan:list) {
            dietPlan.setCreateTime(dietPlan.getCreateDate().split(" ")[1]);
            dietPlan.setCreateDate(dietPlan.getCreateDate().split(" ")[0]);
        }
        return list;
    }
}
