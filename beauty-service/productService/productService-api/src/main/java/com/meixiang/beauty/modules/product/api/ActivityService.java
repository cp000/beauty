package com.meixiang.beauty.modules.product.api;

import com.meixiang.beauty.common.dto.activity.ActivityDTO;
import com.meixiang.beauty.common.dto.activity.ActivityDiscussDTO;
import com.meixiang.beauty.common.dto.activity.ActivityEasemobGroupInfo;
import com.meixiang.beauty.common.dto.activity.AttendedActivityDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.modules.product.DTO.ActivityEasemobGroupInfoDTO;
import com.meixiang.beauty.modules.product.entity.Activity;
import com.meixiang.beauty.modules.product.entity.ActivityEasemobGroup;
import com.meixiang.beauty.modules.product.entity.ActivityUser;
import com.meixiang.beauty.sys.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
public interface ActivityService {

    void sendReservationMessage();

}
