package com.fsnip.jg.modules.cms.service.link;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.Link;

import java.util.List;

/**
 * 链接Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface ILinkService  extends IBaseService<Link>{
    /**
     * 通过编号获取内容标题
     */
    public List<Object[]> findByIds(String ids);
    public void delete(Link link, Boolean isRe);
}
