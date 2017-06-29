package com.fsnip.jg.modules.gen.service.gentable;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.gen.entity.GenTable;
import com.fsnip.jg.modules.gen.entity.GenTemplate;

import java.util.List;

/**
 * 业务表Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface IGenTableService extends IBaseService<GenTable> {
    public List<GenTable> findAll();
    public Page<GenTable> find(Page<GenTable> page, GenTable genTable);
    /**
     * 获取物理数据表列表
     * @param genTable
     * @return
     */
    public List<GenTable> findTableListFormDb(GenTable genTable);
    /**
     * 验证表名是否可用，如果已存在，则返回false
     * @param tableName
     * @return
     */
    public boolean checkTableName(String tableName);
    /**
     * 获取物理数据表列表
     * @param genTable
     * @return
     */
    public GenTable getTableFormDb(GenTable genTable);
}
