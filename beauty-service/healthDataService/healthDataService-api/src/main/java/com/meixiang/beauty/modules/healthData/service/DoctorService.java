package com.meixiang.beauty.modules.healthData.service;

import com.meixiang.beauty.common.dto.hospital.DoctorDTO;
import com.meixiang.beauty.common.persistence.Page;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by zbm84 on 2017/6/27.
 */
public interface DoctorService {

     Page getDoctorList(HttpServletRequest request, Page page, String searchValue, String type);

    String assignedDoctor(String doctorEasemobID, String doctorName, String elderID,String type);

    void addDoctor(DoctorDTO doctorDTO, HttpServletRequest request);

    void batchAddDoctor(File file, HttpServletRequest request) throws Exception;

    DoctorDTO getDoctor(String id);

    void updateDoctor(DoctorDTO doctorDTO) throws Exception;

    void delDoctor(String id);
}
