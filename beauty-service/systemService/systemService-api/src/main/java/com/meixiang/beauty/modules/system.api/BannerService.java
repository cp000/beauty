package com.meixiang.beauty.modules.system.api;


import com.meixiang.beauty.common.dto.system.BannerDTO;
import com.meixiang.beauty.sys.entity.WechatBean;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface BannerService {

    void addBanner(BannerDTO bannerDTO) throws Exception;

    List<BannerDTO> getBannerList();

    void delBanner(String bannerId) throws Exception;
}
