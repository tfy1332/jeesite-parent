/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.sys.service.impl;

import com.fsnip.jg.common.service.TreeService;
import com.fsnip.jg.modules.sys.dao.AreaDao;
import com.fsnip.jg.modules.sys.entity.Area;
import com.fsnip.jg.modules.sys.service.IAreaService;
//import com.fsnip.jg.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域Service
 * @author ThinkGem
 * @version 2014-05-16
 */
//@Service("areaService2")
@Transactional(readOnly = true)
public class AreaService2 extends TreeService<AreaDao, Area>  {

	public List<Area> findAll(){
		return null;
				//UserUtils.getAreaList();
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		//UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		//UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
}
