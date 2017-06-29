package com.fsnip.jg.modules.sys.service;

import com.fsnip.jg.modules.sys.entity.Area;

import java.util.List;

/**
 * Created by tanfy on 2017/4/19 0019.
 * 区域Service
 */
public interface IAreaService {
    public List<Area> findAll();
    public void save(Area area);
    public void delete(Area area);
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public Area get(String id);
}
