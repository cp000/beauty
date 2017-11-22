/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package beauty.modules.sys.dao;

import beauty.common.persistence.annotation.MyBatisDao;
import beauty.common.dto.BannerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Banner
 * @author 张博
 * @version 2017年8月3日
 */
@MyBatisDao
@Repository
public interface SysBannerDao {

    Integer addBanner(BannerDTO bannerDTO);

    List<BannerDTO> getBanner(BannerDTO bannerDTO);

    Integer bannerOff(BannerDTO bannerDTO);

    List<BannerDTO> getBannerList(BannerDTO bannerDTO);

    public void TimeUpdateBannerStatus();
}
