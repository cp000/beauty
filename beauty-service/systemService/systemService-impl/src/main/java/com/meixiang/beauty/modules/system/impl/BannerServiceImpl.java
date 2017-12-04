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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBanner(BannerDTO bannerDTO) throws Exception {
        try{
            sysBannerDao.addBanner(bannerDTO);
        }
        catch (Exception e)
        {
            throw new Exception("添加banner图失败");
        }

    }

    @Override
    public List<BannerDTO> getBannerList() {
        return sysBannerDao.getBannerList();
    }

    @Override
    public void delBanner(String bannerId) throws Exception{

    }

}
