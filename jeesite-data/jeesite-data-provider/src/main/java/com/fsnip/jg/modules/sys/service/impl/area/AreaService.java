/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.sys.service.impl.area;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.sys.dao.AreaDao;
import com.fsnip.jg.modules.sys.dao.DictDao;
import com.fsnip.jg.modules.sys.entity.Area;
import com.fsnip.jg.modules.sys.entity.Dict;
import com.fsnip.jg.modules.sys.entity.Role;
import com.fsnip.jg.modules.sys.service.area.IAreaService;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.fsnip.jg.modules.sys.utils.UserUtils;

/**
 * 区域Service实现
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service("areaService")
public class AreaService extends CrudService<AreaDao, Area> implements IAreaService {

	public List<Area> findAll() {
		return null;
	}

//	public void save(Area area) {
//
//	}
//
//	public void delete(Area area) {
//
//	}

//	public Area get(String id) {
//		return null;
//	}


	public void delete(Area entity, Boolean isRe) {

	}
}
