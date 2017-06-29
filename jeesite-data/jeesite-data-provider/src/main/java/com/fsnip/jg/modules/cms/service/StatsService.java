/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.cms.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.BaseService;
import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.common.utils.DateUtils;
import com.fsnip.jg.modules.cms.dao.ArticleDao;
import com.fsnip.jg.modules.cms.dao.SiteDao;
import com.fsnip.jg.modules.cms.entity.Article;
import com.fsnip.jg.modules.cms.entity.Category;
import com.fsnip.jg.modules.cms.entity.Site;
import com.fsnip.jg.modules.cms.service.stats.IStatsService;
import com.fsnip.jg.modules.sys.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.nimbus.State;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 统计Service
 * @author ThinkGem
 * @version 2013-05-21
 */
@Service
@Transactional(readOnly = true)
public class StatsService  implements IStatsService{

	@Autowired
	private ArticleDao articleDao;
	
	public List<Category> article(Map<String, Object> paramMap) {
		Category category = new Category();
		
		Site site = new Site();
		site.setId(Site.getCurrentSiteId());
		category.setSite(site);
		
		Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
		if (beginDate == null){
			beginDate = DateUtils.setDays(new Date(), 1);
			paramMap.put("beginDate", DateUtils.formatDate(beginDate, "yyyy-MM-dd"));
		}
		category.setBeginDate(beginDate);
		Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
		if (endDate == null){
			endDate = DateUtils.addDays(DateUtils.addMonths(beginDate, 1), -1);
			paramMap.put("endDate", DateUtils.formatDate(endDate, "yyyy-MM-dd"));
		}
		category.setEndDate(endDate);
		
		String categoryId = (String)paramMap.get("categoryId");
		if (categoryId != null && !("".equals(categoryId))){
			category.setId(categoryId);
			category.setParentIds(categoryId);
		}
		
		String officeId = (String)(paramMap.get("officeId"));
		Office office = new Office();
		if (officeId != null && !("".equals(officeId))){
			office.setId(officeId);
			category.setOffice(office);
		}else{
			category.setOffice(office);
		}
		
		List<Category> list = articleDao.findStats(category);
		return list;
	}

	public void delete(State entity, Boolean isRe) {

	}

	public void save(State entity) {

	}

	public State get(State entity) {
		return null;
	}

	public Page<State> findPage(Page<State> page, State state) {
		return null;
	}

	public void delete(State entity) {

	}

	public State get(String id) {
		return null;
	}

	public List<State> findList(State state) {
		return null;
	}
}
