package com.fsnip.jg.modules.cms.service.guestbook;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.Article;
import com.fsnip.jg.modules.cms.entity.Guestbook;

/**
 * 留言Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface IGuestbookService  extends IBaseService<Guestbook>{
    /**
     * 更新索引
     */
    public void createIndex();

    /**
     * 全文检索
     */
    //FIXME 暂不提供
    public Page<Guestbook> search(Page<Guestbook> page, String q, String beginDate, String endDate);
    public void delete(Guestbook guestbook, Boolean isRe);
}
