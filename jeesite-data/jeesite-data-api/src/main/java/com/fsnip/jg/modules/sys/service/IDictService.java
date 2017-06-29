package com.fsnip.jg.modules.sys.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.modules.sys.entity.Dict;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by tanfy on 2017/4/19 0019.
 * 字典Service
 */
public interface IDictService {
    /**
     * 查询字段类型列表
     * @return
     */
    public List<String> findTypeList();
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public Dict get(String id);
    /**
     * 查询分页数据
     * @param page 分页对象
     * @param entity
     * @return
     */
    public Page<Dict> findPage(Page<Dict> page, Dict entity);
    public void save(Dict dict);
    public void delete(Dict dict);
    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<Dict> findList(Dict entity);
    /**
     * 查询所有数据列表
     * @param entity
     * @return
     */
    public List<Dict> findAllList(Dict entity);
}
