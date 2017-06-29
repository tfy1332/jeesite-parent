package com.fsnip.jg.modules.cms.service.filetpl;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.FileTpl;

import java.util.List;

/**
 * Created by tanfy on 2017/5/12 0012.
 */
public interface IFileTplService extends IBaseService<FileTpl> {
    public List<String> getNameListByPrefix(String path);
}
