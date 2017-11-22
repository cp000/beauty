package com.meixiang.beauty.modules.course.dao;

import com.meixiang.beauty.common.dto.PageParamDTO;
import com.meixiang.beauty.common.dto.course.*;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * Created by sunxiao on 2017/8/8.
 */
@MyBatisDao
@Repository
public interface LiveCourseDao {

    Page getLiveCourseByInfo(LiveCourseDTO liveCourseDTO, Page page);

    List<LiveCourseDTO> getAllLiveCourseByInfo(LiveCourseDTO liveCourseDTO);

    LiveCourseDTO getLiveBroadCastDetail(LiveCourseDTO dto);

    void saveLiveCourseRegister(LiveCourseRegisterDTO dto);

    Page getOnlineCourseList(OnlineCourseDTO onlineCourseDTO, Page page);

    OnlineCourseDTO getOnlineCourse(OnlineCourseDTO onlineCourseDTO);

    List<OnlineCourseDataDTO> getOnlineCourseDataList(OnlineCourseDataDTO onlineCourseDataDTO);

    Page getOnlineCourseDiscuss(OnlineCourseDiscussDTO dto, Page page);

    void addOnlineCourseDiscuss(OnlineCourseDiscussDTO onlineCourseDiscussDTO);

    void updateLiveCourse(LiveCourseDTO liveCourseDTO);

    LiveCourseRegisterDTO getLiveCourseRegister(LiveCourseRegisterDTO liveCourseRegisterDTO);

    Page getMyOnlineCourse(OnlineCourseMyCourseDTO dto,Page page);

    List<OnlineCourseDTO> getAllOnlineCourseListByInfo(OnlineCourseDTO dto);

    List<OnlineCourseMyCourseDTO> getAllMyOnlineCourseByInfo(OnlineCourseMyCourseDTO dto);

    List<OnlineCourseDTO> findOnlineCoursePage(PageParamDTO<String> pageParamDTO);
}
