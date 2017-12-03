package com.meixiang.beauty.modules.system.impl;


import com.meixiang.beauty.common.dto.system.BannerDTO;
import com.meixiang.beauty.modules.system.api.BannerService;
import com.meixiang.beauty.sys.dao.SysBannerDao;
import com.meixiang.beauty.sys.dao.SysBannerResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class BannerServiceImpl implements BannerService {


    @Autowired
    private SysBannerDao sysBannerDao;

    @Autowired
    private SysBannerResourceDao sysBannerResourceDao;

    @Override
    public Integer addBanner(BannerDTO bannerDTO) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(bannerDTO.getStartDate()))) {
            List<BannerDTO> list = sysBannerDao.getBannerList();
            if (list.size()>0) {
                BannerDTO bannerDTO1=list.get(0);
                bannerDTO1.setStatus("1");
                sysBannerDao.bannerOff(bannerDTO1);
            }
            bannerDTO.setStatus("0");
        }
        return sysBannerDao.addBanner(bannerDTO);
    }

    @Override
    public List<BannerDTO> getBannerList() {
        return sysBannerDao.getBannerList();
    }

    @Override
    public Integer bannerOff(BannerDTO bannerDTO) {
        return sysBannerDao.bannerOff(bannerDTO);
    }

}
