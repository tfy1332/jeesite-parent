package com.fsnip.jg.modules.gen.service.genscheme;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.gen.entity.GenScheme;
import com.fsnip.jg.modules.gen.entity.GenTemplate;

/**
 * 生成方案Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface IGenSchemeService extends IBaseService<GenScheme> {
    public Page<GenScheme> find(Page<GenScheme> page, GenScheme genScheme);
}
