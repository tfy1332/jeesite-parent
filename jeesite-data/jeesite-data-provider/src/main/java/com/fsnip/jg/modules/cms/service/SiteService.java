/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.cms.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.cms.dao.SiteDao;
import com.fsnip.jg.modules.cms.entity.Site;
//import com.fsnip.jg.modules.cms.utils.CmsUtils;
import com.fsnip.jg.modules.cms.service.site.ISiteService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 站点Service
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class SiteService extends CrudService<SiteDao, Site> implements ISiteService{

	public Page<Site> findPage(Page<Site> page, Site site) {
//		DetachedCriteria dc = siteDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(site.getName())){
//			dc.add(Restrictions.like("name", "%"+site.getName()+"%"));
//		}
//		dc.add(Restrictions.eq(Site.FIELD_DEL_FLAG, site.getDelFlag()));
//		//dc.addOrder(Order.asc("id"));
//		return siteDao.find(page, dc);
		
		site.getSqlMap().put("site", dataScopeFilter(site.getCurrentUser(), "o", "u"));
		
		return super.findPage(page, site);
	}

	@Transactional(readOnly = false)
	public void save(Site site) {
		if (site.getCopyright()!=null){
			site.setCopyright(StringEscapeUtils.unescapeHtml4(site.getCopyright()));
		}
		super.save(site);
//		CmsUtils.removeCache("site_"+site.getId());
//		CmsUtils.removeCache("siteList");
	}
	
	@Transactional(readOnly = false)
	public void delete(Site site, Boolean isRe) {
		//siteDao.updateDelFlag(id, isRe!=null&&isRe?Site.DEL_FLAG_NORMAL:Site.DEL_FLAG_DELETE);
		site.setDelFlag(isRe!=null&&isRe? Site.DEL_FLAG_NORMAL: Site.DEL_FLAG_DELETE);
		super.delete(site);
		//siteDao.delete(id);
//		CmsUtils.removeCache("site_"+site.getId());
//		CmsUtils.removeCache("siteList");
	}

	public Page<Site> find(Page<Site> page, Site site) {
		return null;
	}
}
