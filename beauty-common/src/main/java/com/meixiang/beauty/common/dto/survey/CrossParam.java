package com.meixiang.beauty.common.dto.survey;

import java.util.List;

/**
 * Created by sunxiao on 2017/9/26.
 */
public class CrossParam {

    List<SurveyDTO> independentVariableList;

    List<SurveyDTO> dependentVariableList;

    public List<SurveyDTO> getIndependentVariableList() {
        return independentVariableList;
    }

    public void setIndependentVariableList(List<SurveyDTO> independentVariableList) {
        this.independentVariableList = independentVariableList;
    }

    public List<SurveyDTO> getDependentVariableList() {
        return dependentVariableList;
    }

    public void setDependentVariableList(List<SurveyDTO> dependentVariableList) {
        this.dependentVariableList = dependentVariableList;
    }
}