/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.cms.service;

import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.cms.dao.ArticleDataDao;
import com.fsnip.jg.modules.cms.entity.ArticleData;
import com.fsnip.jg.modules.cms.service.articledata.IArticleDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 站点Service
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> implements IArticleDataService {
    public void delete(ArticleData entity, Boolean isRe) {

    }
}
