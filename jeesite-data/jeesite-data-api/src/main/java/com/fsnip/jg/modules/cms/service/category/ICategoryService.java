package com.fsnip.jg.modules.cms.service.category;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.Category;
import com.fsnip.jg.modules.sys.entity.User;

import java.util.List;

/**
 * 栏目Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface ICategoryService extends IBaseService<Category>{
    public List<Category> findByParentId(String parentId, String siteId);
    public List<Category> findByUser(boolean isCurrentSite, String module);
    /**
     * 重写方法 传入 登录用户对象 by tanfy 2017-04-21
     * @param user
     * @param isCurrentSite
     * @param module
     * @return
     */
    public List<Category> findByUser(User user, boolean isCurrentSite, String module);

    }
