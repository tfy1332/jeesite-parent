package com.fsnip.jg.common.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.modules.cms.entity.Link;
import com.fsnip.jg.modules.cms.entity.Site;
import com.fsnip.jg.modules.gen.entity.GenTable;
import com.fsnip.jg.test.entity.TestTree;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类 接口
 * Created by tanfy on 2017/5/12 0012.
 */
public interface IBaseService<T> {
    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    public void save(T entity);
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity) ;
    public Page<T> findPage(Page<T> page, T t);
//    public Page<T> find(Page<T> page, T t);
    /**
     * 删除数据
     * @param entity
     */
    public void delete(T entity);
    public void delete(T entity, Boolean isRe);
    public List<T> findList(T t);
}
