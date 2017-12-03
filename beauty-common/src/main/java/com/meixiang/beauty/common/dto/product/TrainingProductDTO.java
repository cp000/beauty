package com.meixiang.beauty.common.dto.product;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TrainingProductDTO {

    @JSONField(name = "trainingProductName")
    private String trainingProductName;

    @JSONField(name = "brand")
    private String brand;

    @JSONField(name = "trainingProductType")
    private String trainingProductType;

    @JSONField(name = "price")
    private long price;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "listCourse")
    private List<CourseDTO> courseDTOList;

    public String getTrainingProductName() {
        return trainingProductName;
    }

    public void setTrainingProductName(String trainingProductName) {
        this.trainingProductName = trainingProductName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTrainingProductType() {
        return trainingProductType;
    }

    public void setTrainingProductType(String trainingProductType) {
        this.trainingProductType = trainingProductType;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CourseDTO> getCourseDTOList() {
        return courseDTOList;
    }

    public void setCourseDTOList(List<CourseDTO> courseDTOList) {
        this.courseDTOList = courseDTOList;
    }
}