package com.meixiang.beauty.modules.account.api;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.practitioner.detection.DetectionDTO;
import com.meixiang.beauty.common.dto.practitioner.test.TestReportDTO;
import com.meixiang.beauty.common.dto.practitioner.treatment.TreatmentDTO;
import com.meixiang.beauty.sys.entity.healthData.HealthData;

import java.util.List;

/**
 * Created by sunxiao on 2017/5/11.
 */
public interface HealthDataService {

    ResponseDTO<List> getTestReport(String elderId, String startDate, String endDate);

    ResponseDTO<List> getTreatmentRecord(String elderId, String startDate, String endDate);

    ResponseDTO<DetectionDTO> getHealthDataFromMongo(String detectionType, String detectionDateType, String elderId);

    HealthData getSingleHealthDataFromMongo(String id);

    TestReportDTO getSingleTestReportFromMongo(String id);

    void saveHealthDataToMongo(DetectionDTO detectionDTO) throws Exception;

    void saveControlTargetToMongo(DetectionDTO detectionDTO);

    DetectionDTO getControlTargetFromMongo(String elderId, String detectionType);

    void createTestReport(TestReportDTO testReportDTO) throws Exception;

    void createTreatment(TreatmentDTO treatmentDTO) throws Exception;

    TreatmentDTO getSingleTreatmentRecordFromMongo(String id);

    void makeHealthData();
}
