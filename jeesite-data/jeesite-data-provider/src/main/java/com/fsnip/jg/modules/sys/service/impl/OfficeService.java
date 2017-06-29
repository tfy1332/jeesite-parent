/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.sys.service.impl;

import com.fsnip.jg.common.service.BaseService;
import com.fsnip.jg.common.service.TreeService;
import com.fsnip.jg.modules.sys.dao.OfficeDao;
import com.fsnip.jg.modules.sys.entity.Office;
import com.fsnip.jg.modules.sys.entity.User;
import com.fsnip.jg.modules.sys.service.IOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//import com.fsnip.jg.modules.sys.utils.UserUtils;

/**
 * 机构Service
 * @author ThinkGem
 * @version 2014-05-16
 */
//@Service
@Transactional(readOnly = true)
public class OfficeService extends TreeService<OfficeDao, Office>  implements IOfficeService{

	public List<Office> findAll(){
		return null;
				//UserUtils.getOfficeList();
	}

	public List<Office> findList(Boolean isAll){
		if (isAll != null && isAll){
			return getOfficeAllList();
			//return UserUtils.getOfficeAllList();
		}else{
			//return UserUtils.getOfficeList();
		}
		return null;
	}
	public List<Office> findList(Boolean isAll,User user){
		if (isAll != null && isAll){
			return getOfficeAllList();
			//return UserUtils.getOfficeAllList();
		}else{
			return getOfficeList( user);
			//return UserUtils.getOfficeList();
		}
//		return null;
	}

	/**
	 * 获取当前用户有权限访问的部门 by tanfy 2017-04-21
	 * @return
	 */
	public  List<Office> getOfficeAllList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = null;
//		(List<Office>)getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null){
			officeList = dao.findAllList(new Office());
		}
		return officeList;
	}
	/**
	 * 获取当前用户有权限访问的部门 by tanfy 2017-04-21
	 * @return
	 */
	public  List<Office> getOfficeList(User user){
		@SuppressWarnings("unchecked")
		List<Office> officeList = null;
//		(List<Office>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
//			User user = getUser();
			if (user.isAdmin()){
				officeList = dao.findAllList(new Office());
			}else{
				Office office = new Office();
				office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
				officeList = dao.findList(office);
			}
//			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}
	@Transactional(readOnly = true)
	public List<Office> findList(Office office){
		if(office != null){
			office.setParentIds(office.getParentIds()+"%");
			return dao.findByParentIdsLike(office);
		}
		return  new ArrayList<Office>();
	}
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		super.save(office);
		//UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Office office) {
		super.delete(office);
		//UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
}
