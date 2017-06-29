package com.fsnip.jg.modules.cms.service.stats;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.Category;

import javax.swing.plaf.nimbus.State;
import java.util.List;
import java.util.Map;

/**
 * 统计Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface IStatsService extends IBaseService<State>{
    public List<Category> article(Map<String, Object> paramMap);
}
