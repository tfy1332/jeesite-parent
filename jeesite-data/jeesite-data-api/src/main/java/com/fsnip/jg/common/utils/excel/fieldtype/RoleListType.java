/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.common.utils.excel.fieldtype;

import com.fsnip.jg.common.utils.Collections3;
import com.fsnip.jg.common.utils.SpringContextHolder;
import com.fsnip.jg.common.utils.StringUtils;
import com.fsnip.jg.modules.sys.entity.Role;
//import com.fsnip.jg.modules.sys.service.impl.SystemService;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 字段类型转换
 * @author ThinkGem
 * @version 2013-5-29
 */
public class RoleListType {

//	private static SystemService systemService = SpringContextHolder.getBean(SystemService.class);

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		List<Role> roleList = Lists.newArrayList();
		List<Role> allRoleList = null;
				//systemService.findAllRole();
		for (String s : StringUtils.split(val, ",")){
			for (Role e : allRoleList){
				if (StringUtils.trimToEmpty(s).equals(e.getName())){
					roleList.add(e);
				}
			}
		}
		return roleList.size()>0?roleList:null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null){
			@SuppressWarnings("unchecked")
			List<Role> roleList = (List<Role>)val;
			return Collections3.extractToString(roleList, "name", ", ");
		}
		return "";
	}

}
