package com.meixiang.beauty.modules.system.api;

import com.meixiang.beauty.common.dto.PageParamDTO;
import com.meixiang.beauty.common.dto.practitioner.healthServicePackage.HealthServicePackageDTO;
import com.meixiang.beauty.common.dto.practitioner.healthServicePackage.HealthServicePackageTemplateDTO;
import com.meixiang.beauty.common.dto.practitioner.member.MemberDTO;
import java.util.List;

public interface HealthServicePackage {

    List<HealthServicePackageDTO> getHealthServicePackageList(PageParamDTO<MemberDTO> pageParamDto) throws Exception;

    List<HealthServicePackageTemplateDTO> getHealthServicePackageTemplateList(PageParamDTO pageParamDto) throws Exception;

    HealthServicePackageTemplateDTO getHealthServicePackageTemplateDetail(String healthServicePackageTemplateId) throws Exception;

    HealthServicePackageDTO createHealthServicePackage(HealthServicePackageDTO healthServicePackageDto,String userid) throws Exception;

    HealthServicePackageDTO getOnGoingHealthServicePackage(String healthServicePackageId);

    MemberDTO getElderContactInfo(String elderId);
}
