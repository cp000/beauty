package com.meixiang.beauty.modules.wechat.impl;

import com.meixiang.beauty.common.bean.CustomBean;
import com.meixiang.beauty.modules.wechat.dao.UserQRCodeDao;
import com.meixiang.beauty.modules.wechat.dao.WechatInfoDao;
import com.meixiang.beauty.modules.training.entity.UserQRCode;
import com.meixiang.beauty.modules.training.api.WechatInfoService;
import com.meixiang.beauty.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class WechatServiceImpl implements WechatInfoService {
	
	@Autowired
	private UserQRCodeDao ucd;
	
	@Autowired
	private WechatInfoDao wechatInfoDao;
	
	@Autowired
	private SystemService systemService;

	@Override
	public int insertUserQRCode(UserQRCode usercode) {
		// TODO Auto-generated method stub
		return ucd.insertUserQRCode(usercode);
	}

	@Override
	public Map<String,Object> getQRCodeFromOpenid(String openid) {
		// TODO Auto-generated method stub
		return ucd.getQRCodeFromOpenid(openid);
	}
	
	public  List<Map<String,Object>> getShareFromOpenid(Map<String,Object> m){
		List<String> openidList=ucd.getFollowerListByMarketer(m.get("openid").toString());
		m.put("openidList", openidList);
		return ucd.getShareFromOpenid(m);
	}

	@Override
	public List<Map<String, Object>> getShareFromOpenidAndAPITime(
			Map<String, Object> m) {
		// TODO Auto-generated method stub
		return ucd.getShareFromOpenidAndAPITime(m);
	}

	@Override
	public void getCustomerOnlineTime(ArrayList<CustomBean> list) {
		wechatInfoDao.getCustomerOnlineTime(list);
	}
	
	@Override
	public List<Map<String, Object>> findAttentions(String userId, String date) {
		return wechatInfoDao.selectAttentions(userId, date);
	}

}
