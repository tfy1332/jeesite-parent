/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.gen.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.BaseService;
import com.fsnip.jg.common.utils.StringUtils;
import com.fsnip.jg.modules.gen.dao.GenTemplateDao;
import com.fsnip.jg.modules.gen.entity.GenTemplate;
import com.fsnip.jg.modules.gen.service.gentemplate.IGenTemplateService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 代码模板Service
 * @author ThinkGem
 * @version 2013-10-15
 */
@Service
@Transactional(readOnly = true)
public class GenTemplateService extends BaseService implements IGenTemplateService {

	@Autowired
	private GenTemplateDao genTemplateDao;
	
	public GenTemplate get(String id) {
		return genTemplateDao.get(id);
	}
	
	public Page<GenTemplate> find(Page<GenTemplate> page, GenTemplate genTemplate) {
		genTemplate.setPage(page);
		page.setList(genTemplateDao.findList(genTemplate));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(GenTemplate genTemplate) {
		if (genTemplate.getContent()!=null){
			genTemplate.setContent(StringEscapeUtils.unescapeHtml4(genTemplate.getContent()));
		}
		if (StringUtils.isBlank(genTemplate.getId())){
			genTemplate.preInsert();
			genTemplateDao.insert(genTemplate);
		}else{
			genTemplate.preUpdate();
			genTemplateDao.update(genTemplate);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(GenTemplate genTemplate) {
		genTemplateDao.delete(genTemplate);
	}

	public GenTemplate get(GenTemplate entity) {
		return null;
	}

	public Page<GenTemplate> findPage(Page<GenTemplate> page, GenTemplate genTemplate) {
		return null;
	}

	public void delete(GenTemplate entity, Boolean isRe) {

	}

	public List<GenTemplate> findList(GenTemplate genTemplate) {
		return null;
	}
}
