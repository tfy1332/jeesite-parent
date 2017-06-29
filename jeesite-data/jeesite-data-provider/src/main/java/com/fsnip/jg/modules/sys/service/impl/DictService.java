/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.sys.service.impl;

import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.sys.dao.DictDao;
import com.fsnip.jg.modules.sys.entity.Dict;
import com.fsnip.jg.modules.sys.service.IDictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import com.fsnip.jg.modules.sys.utils.DictUtils;

/**
 * 字典Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict>  implements IDictService{
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		//CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		//CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	public List<Dict> findAllList(Dict entity) {
		return dao.findAllList(entity);
	}
}
