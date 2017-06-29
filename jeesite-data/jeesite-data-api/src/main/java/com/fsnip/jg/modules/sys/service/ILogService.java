package com.fsnip.jg.modules.sys.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.modules.sys.entity.Log;

/**
 * Created by tanfy on 2017/4/19 0019.
 * 日志Service
 */
public interface ILogService {
    public Page<Log> findPage(Page<Log> page, Log log);
}
