package com.meixiang.beauty.modules.transaction.api;


import com.meixiang.beauty.common.dto.practitioner.Settings.FeedbackDTO;

/**
 * Created by zbm84 on 2017/5/11.
 */

public interface FeedbackService {

    public int insertFeedback(FeedbackDTO feedbackDto);

}
