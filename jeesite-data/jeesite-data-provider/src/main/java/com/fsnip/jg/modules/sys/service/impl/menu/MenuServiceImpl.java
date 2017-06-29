package com.fsnip.jg.modules.sys.service.impl.menu;

import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.sys.dao.DictDao;
import com.fsnip.jg.modules.sys.dao.MenuDao;
import com.fsnip.jg.modules.sys.entity.Dict;
import com.fsnip.jg.modules.sys.entity.Menu;
import com.fsnip.jg.modules.sys.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单Service实现
 * Created by tanfy on 2017/5/15 0015.
 */
@Service
public class MenuServiceImpl extends CrudService<MenuDao, Menu> implements IMenuService{
    @Autowired
    private MenuDao menuDao;
    public List<Menu> findByUserId(Menu menu) {
        return menuDao.findByUserId(menu);
    }

    public void delete(Menu entity, Boolean isRe) {

    }
}
