/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.cms.web;

import com.fsnip.jg.common.web.BaseController;
import com.fsnip.jg.modules.cms.service.category.ICategoryService;
import com.fsnip.jg.modules.sys.entity.Role;
import com.fsnip.jg.modules.sys.entity.User;
//import com.fsnip.jg.modules.sys.security.SystemAuthorizingRealm;
import com.fsnip.jg.modules.sys.service.ISystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import static com.fsnip.jg.modules.sys.security.SystemAuthorizingRealm.getPrincipal;


/**
 * 内容管理Controller
 * @author ThinkGem
 * @version 2013-4-21
 */
@Controller
@RequestMapping(value = "${adminPath}/cms")
public class CmsController extends BaseController {

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ISystemService systemService;

	@RequiresPermissions("cms:view")
	@RequestMapping(value = "")
	public String index() {
		return "modules/cms/cmsIndex";
	}

	@RequiresPermissions("cms:view")
	@RequestMapping(value = "tree")
	public String tree(Model model) {
//		model.addAttribute("categoryList", categoryService.findByUser(true, null));
		User user  = getUser();
		model.addAttribute("categoryList", categoryService.findByUser(user,true, null));
		return "modules/cms/cmsTree";
	}

	@RequiresPermissions("cms:view")
	@RequestMapping(value = "none")
	public String none() {
		return "modules/cms/cmsNone";
	}

}
