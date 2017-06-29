/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fsnip.jg.modules.cms.service.article;


import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.Article;

import java.util.List;

/**
 * 文章Service
 * @author ThinkGem
 * @version 2013-05-15
 */
public interface IArticleService extends IBaseService<Article> {

    /**
     * 点击数加一
     */
    public void updateHitsAddOne(String id);
    /**
     * 通过编号获取内容标题
     * @return new Object[]{栏目Id,文章Id,文章标题}
     */
    public List<Object[]> findByIds(String ids);
    /**
     * 更新索引
     */
    public void createIndex();
    /**
     * 全文检索
     */
    //FIXME 暂不提供检索功能
    public Page<Article> search(Page<Article> page, String q, String categoryId, String beginDate, String endDate);
    public void delete(Article article, Boolean isRe);
}
