/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.cms.web;

import com.fsnip.jg.common.config.Global;
import com.fsnip.jg.common.utils.StringUtils;
import com.fsnip.jg.common.web.BaseController;
import com.fsnip.jg.modules.cms.entity.Article;
import com.fsnip.jg.modules.cms.entity.Category;
import com.fsnip.jg.modules.cms.entity.FileTpl;
import com.fsnip.jg.modules.cms.entity.Site;
import com.fsnip.jg.modules.cms.service.category.ICategoryService;
import com.fsnip.jg.modules.cms.service.filetpl.IFileTplService;
import com.fsnip.jg.modules.cms.service.site.ISiteService;
import com.fsnip.jg.modules.cms.utils.TplUtils;
import com.fsnip.jg.modules.sys.entity.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 栏目Controller
 * @author ThinkGem
 * @version 2013-4-21
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/category")
public class CategoryController extends BaseController {

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	ServletContext context;
//	@Autowired
//   	private IFileTplService fileTplService;
	@Autowired
	private ISiteService siteService;

	@ModelAttribute("category")
	public Category get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return categoryService.get(id);
		}else{
			return new Category();
		}
	}

	@RequiresPermissions("cms:category:view")
	@RequestMapping(value = {"list", ""})
	public String list(Model model) {
		List<Category> list = Lists.newArrayList();
		User user =getUser();
		List<Category> sourcelist = categoryService.findByUser(user,true, null);
		Category.sortList(list, sourcelist, "1");
		model.addAttribute("list", list);
		return "modules/cms/categoryList";
	}

	@RequiresPermissions("cms:category:view")
	@RequestMapping(value = "form")
	public String form(Category category, Model model) {
		if (category.getParent()==null||category.getParent().getId()==null){
			category.setParent(new Category("1"));
		}
		Category parent = categoryService.get(category.getParent().getId());
		category.setParent(parent);
		if (category.getOffice()==null||category.getOffice().getId()==null){
			category.setOffice(parent.getOffice());
		}
		model.addAttribute("listViewList",getTplContent(Category.DEFAULT_TEMPLATE));
		model.addAttribute("category_DEFAULT_TEMPLATE", Category.DEFAULT_TEMPLATE);
		model.addAttribute("contentViewList",getTplContent(Article.DEFAULT_TEMPLATE));
		model.addAttribute("article_DEFAULT_TEMPLATE", Article.DEFAULT_TEMPLATE);
		model.addAttribute("office", category.getOffice());
		model.addAttribute("category", category);
		return "modules/cms/categoryForm";
	}

	@RequiresPermissions("cms:category:edit")
	@RequestMapping(value = "save")
	public String save(Category category, Model model, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/cms/category/";
		}
		if (!beanValidator(model, category)){
			return form(category, model);
		}
		categoryService.save(category);
		addMessage(redirectAttributes, "保存栏目'" + category.getName() + "'成功");
		return "redirect:" + adminPath + "/cms/category/";
	}

	@RequiresPermissions("cms:category:edit")
	@RequestMapping(value = "delete")
	public String delete(Category category, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/cms/category/";
		}
		if (Category.isRoot(category.getId())){
			addMessage(redirectAttributes, "删除栏目失败, 不允许删除顶级栏目或编号为空");
		}else{
			categoryService.delete(category);
			addMessage(redirectAttributes, "删除栏目成功");
		}
		return "redirect:" + adminPath + "/cms/category/";
	}

	/**
	 * 批量修改栏目排序
	 */
	@RequiresPermissions("cms:category:edit")
	@RequestMapping(value = "updateSort")
	public String updateSort(String[] ids, Integer[] sorts, RedirectAttributes redirectAttributes) {
		int len = ids.length;
		Category[] entitys = new Category[len];
		for (int i = 0; i < len; i++) {
			entitys[i] = categoryService.get(ids[i]);
			entitys[i].setSort(sorts[i]);
			categoryService.save(entitys[i]);
		}
		addMessage(redirectAttributes, "保存栏目排序成功!");
		return "redirect:" + adminPath + "/cms/category/";
	}

	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(String module, @RequestParam(required=false) String extId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		User user =getUser();
		List<Category> list = categoryService.findByUser(user,true, module);
		for (int i=0; i<list.size(); i++){
			Category e = list.get(i);
			if (extId == null || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParent()!=null?e.getParent().getId():0);
				map.put("name", e.getName());
				map.put("module", e.getModule());
				mapList.add(map);
			}
		}
		return mapList;
	}

	private List<String> getTplContent(String prefix) {
		List<String> tplList = getNameListByPrefix(siteService.get(Site.getCurrentSiteId()).getSolutionPath());
		tplList = TplUtils.tplTrim(tplList, prefix, "");
		return tplList;
	}
	public List<String> getNameListByPrefix(String path) {
		List<FileTpl> list = getListByPath(path, false);
		List<String> result = new ArrayList<String>(list.size());
		for (FileTpl tpl : list) {
			result.add(tpl.getName());
		}
		return result;
	}

	public List<FileTpl> getListByPath(String path, boolean directory) {
		File f = new File(context.getRealPath(path));
		if (f.exists()) {
			File[] files = f.listFiles();
			if (files != null) {
				List<FileTpl> list = new ArrayList<FileTpl>();
				for (File file : files) {
					if(file.isFile() || directory)
						list.add(new FileTpl(file, context.getRealPath("")));
				}
				return list;
			} else {
				return new ArrayList<FileTpl>(0);
			}
		} else {
			return new ArrayList<FileTpl>(0);
		}
	}
}
