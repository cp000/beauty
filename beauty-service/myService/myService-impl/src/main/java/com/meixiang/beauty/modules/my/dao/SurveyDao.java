package com.meixiang.beauty.modules.my.dao;


import com.meixiang.beauty.common.dto.survey.AnswerDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunxiao on 2017/8/8.
 */
@MyBatisDao
@Repository
public interface SurveyDao {

    List<AnswerDTO> findSurveyAnswer(AnswerDTO answerDTO);

    void createSurveyAnswer(AnswerDTO answerDTO);

    void updateSurveyAnswer(AnswerDTO answerDTO);

    int getAnswerUserNum();

    void batchCreateSurveyAnswerFinal(List<AnswerDTO> list);

    List<String> getSurveyIdCard();

    List<AnswerDTO> getSurveyAnswer(String idCard);

    void deleteSurvey(String idCard);
}
