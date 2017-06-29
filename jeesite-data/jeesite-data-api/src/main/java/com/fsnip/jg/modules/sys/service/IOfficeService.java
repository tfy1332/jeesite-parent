package com.fsnip.jg.modules.sys.service;

import com.fsnip.jg.modules.sys.entity.Office;
import com.fsnip.jg.modules.sys.entity.User;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by tanfy on 2017/4/19 0019.
 * 机构Service
 */
public interface IOfficeService {
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public Office get(String id);
    public List<Office> findList(Boolean isAll);
    //by tanfy 2017-04-21 多传一个参数 当前登录用户对象
    public List<Office> findList(Boolean isAll, User user);
    public List<Office> findList(Office office);
    public List<Office> findAll();
    public void save(Office office);
    public void delete(Office office);
}
