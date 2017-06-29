package com.fsnip.jg.modules.sys.service.area;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.sys.entity.Area;
import com.fsnip.jg.modules.sys.entity.Role;
import com.fsnip.jg.modules.sys.entity.User;

import java.util.List;

/**
 * 区域Service
 * Created by tanfy on 2017/4/19 0019.
 *
 */
public interface IAreaService extends IBaseService<Area> {
    public List<Area> findAll();
//    public void save(Area area);
//    public void delete(Area area);
    /**
     * 获取单条数据
     * @param id
     * @return
     */
//    public Area get(String id);
}
