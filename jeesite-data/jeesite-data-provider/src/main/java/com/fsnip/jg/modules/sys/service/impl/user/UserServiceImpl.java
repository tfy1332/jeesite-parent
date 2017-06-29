package com.fsnip.jg.modules.sys.service.impl.user;

import com.fsnip.jg.common.service.CrudService;
import com.fsnip.jg.modules.sys.dao.UserDao;
import com.fsnip.jg.modules.sys.entity.User;
import com.fsnip.jg.modules.sys.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**用户Service 实现
 * Created by tanfy on 2017/5/15 0015.
 */
@Service
public class UserServiceImpl extends CrudService<UserDao, User> implements IUserService {

    @Autowired
    private UserDao userDao;
    public void delete(User entity, Boolean isRe) {

    }
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    public User getUserByLoginName(String loginName) {
        User user = userDao.getByLoginName(new User(null, loginName));
        if (user == null){
            return null;
        }
        return user;
        //UserUtils.getByLoginName(loginName);
    }
}
