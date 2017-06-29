package com.fsnip.jg.modules.sys.service.menu;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.sys.entity.Menu;
import com.fsnip.jg.modules.sys.entity.User;

import java.util.List;

/**
 * 菜单Menu Service
 * Created by tanfy on 2017/5/15 0015.
 */
public interface IMenuService extends IBaseService<Menu> {
    public List<Menu> findByUserId(Menu menu);
}
