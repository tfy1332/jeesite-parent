package com.fsnip.jg.modules.sys.service.user;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.sys.entity.User;

/**
 * 用户User Service
 * Created by tanfy on 2017/5/15 0015.
 */
public interface IUserService extends IBaseService<User> {
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    public User getUserByLoginName(String loginName);
}
