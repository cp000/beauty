package com.meixiang.beauty.modules.health.service;

import com.meixiang.beauty.common.dto.PageParamDTO;
import com.meixiang.beauty.common.dto.elder.RelativeElderDTO;
import com.meixiang.beauty.common.dto.practitioner.healthArchive.*;
import com.meixiang.beauty.common.dto.practitioner.member.MemberDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.sys.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public interface HealthArchive {

    Page getElderBasicInfoList(String id, Page page, String search);

    BasicInfoDTO getElderBasicInfo(String elderId) throws Exception;

    List<PhysicalExaminationDTO> getPhysicalExaminationList(PageParamDTO<MemberDTO> pageParamDto) throws Exception;

    List<HealthAssessmentDTO> getHealthAssessmentList(PageParamDTO<MemberDTO> pageParamDto) throws Exception;

    HealthAssessmentDTO getHealthAssessment(String healthAssessmentId,String keyId) throws Exception;

    List<HealthAssessmentTemplateDTO> GetHealthArchiveHealthAssessmentTemplateList(PageParamDTO pageParamDto) throws Exception;

    List<PhysicalExaminationTemplateDTO> getPhysicalExaminationTemplateList(PageParamDTO pageParamDto) throws Exception;

    PhysicalExaminationDTO getPhysicalExamination(String physicalExaminationId) throws Exception;

    PhysicalExaminationDTO createPhysicalExamination(PhysicalExaminationDTO physicalExaminationDTO) throws Exception;

    void createHealthAssessment(HealthAssessmentDTO healthAssessmentAnswer) throws Exception;

    void addElderBasicInfo(BasicInfoDTO basicInfoDTO,HttpServletRequest request) throws Exception;

    void batchAddElderBasicInfo(File file,HttpServletRequest request) throws Exception;

    void updateElderBasicInfo(BasicInfoDTO basicInfoDTO) throws Exception;

    void delElderBasicInfo(String id,HttpServletRequest request) throws Exception;

    List<RelativeElderDTO> getRelativeList(User user);

}