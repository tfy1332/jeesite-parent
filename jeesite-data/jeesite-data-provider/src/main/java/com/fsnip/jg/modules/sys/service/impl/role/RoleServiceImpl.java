package com.fsnip.jg.modules.sys.service.impl.role;

import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.sys.dao.AreaDao;
import com.fsnip.jg.modules.sys.dao.RoleDao;
import com.fsnip.jg.modules.sys.entity.Area;
import com.fsnip.jg.modules.sys.entity.Role;
import com.fsnip.jg.modules.sys.service.role.IRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色Service实现
 * Created by tanfy on 2017/5/15 0015.
 */
@Service("roleService")
public class RoleServiceImpl extends CrudService<RoleDao, Role> implements IRoleService {
    public void delete(Role entity, Boolean isRe) {

    }
}
