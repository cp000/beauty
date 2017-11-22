/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.service;

import java.util.List;

import com.meixiang.beauty.common.utils.CacheUtils;
import com.meixiang.beauty.sys.utils.DictUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meixiang.beauty.common.service.CrudService;
import com.meixiang.beauty.sys.dao.DictDao;
import com.meixiang.beauty.sys.entity.Dict;

/**
 * 字典Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = false)
public class DictService extends CrudService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Override
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}
	
	@Override
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	public List findListByInfo(Dict dict){
		return dao.findListByInfo(dict);
	}

}