/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.dto.BannerResourceDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * Banner
 * @author 张博
 * @version 2017年8月3日
 */
@MyBatisDao
@Repository
public interface SysBannerResourceDao {

    Integer addSysBannerResource(BannerResourceDTO bannerResourceDTO);

    Integer updateSysBannerResource(BannerResourceDTO bannerResourceDTO);

    Page getBannerResourcePage(BannerResourceDTO bannerResourceDTO,Page page);
}
