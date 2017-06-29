package com.fsnip.jg.modules.sys.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.sys.entity.Menu;
import com.fsnip.jg.modules.sys.entity.Role;
import com.fsnip.jg.modules.sys.entity.User;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.session.mgt.eis.SessionDAO;

import java.util.List;

/**
 * Created by tanfy on 2017/4/19 0019.
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 */
public interface ISystemService extends IBaseService{
    public Menu getMenu(String id);
    public List<Menu> findAllMenu();
    /**
     * 查询所有数据列表
     * @param entity
     * @return
     */
    public List<Menu> findAllList(Menu entity);
    public List<Menu> findByUserId(Menu menu);
    public void saveMenu(Menu menu);
    public void deleteMenu(Menu menu);
    public void updateMenuSort(Menu menu);
    public Role getRole(String id);
    public List<Role> findAllRole();
    public void saveRole(Role role);
    public void deleteRole(Role role);
    public Page<User> findUser(Page<User> page, User user);
    /**
     * 无分页查询人员列表
     * @param user
     * @return
     */
    public List<User> findUser(User user);
    /**
     * 获取用户
     * @param id
     * @return
     */
    public User getUser(String id);
    public Boolean outUserInRole(Role role, User user);
    public User assignUserToRole(Role role, User user);
    public Role getRoleByName(String name);
    public Role getRoleByEnname(String enname);
    public void saveUser(User user);
    public void deleteUser(User user);
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    public User getUserByLoginName(String loginName);
    public void updateUserInfo(User user);
    public void updatePasswordById(String id, String loginName, String newPassword);
    /**
     * 通过部门ID获取用户列表，仅返回用户id和name（树查询用户时用）
     * @param user
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<User> findUserByOfficeId(String officeId);
    //public SessionDAO getSessionDao();
    public void updateUserLoginInfo(User user);
    /**
     * 查询数据列表，如果需要分页，请设置分页对象，
     * 如：entity.setPage(new Page<T>());
     * @param entity
     * @return
     */
    public List<Role> findList(Role entity);
    public List<Role> findRole(Role role);
}
