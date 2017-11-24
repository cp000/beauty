package com.meixiang.beauty.modules.system.api;

import com.meixiang.beauty.common.dto.elder.RelativeElderDTO;
import java.util.List;

public interface RelativeElderService {

    List<RelativeElderDTO> relativeElderInfo(String elderID);
}
