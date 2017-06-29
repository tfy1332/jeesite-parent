package com.fsnip.jg.modules.oa.service.oanotify;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.oa.entity.Leave;
import com.fsnip.jg.modules.oa.entity.OaNotify;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by tanfy on 2017/4/20 0020.
 * 通知通告Service
 */
public interface IOaNotifyService extends IBaseService<OaNotify> {
    public OaNotify get(String id);
    /**
     * 查询数据列表，如果需要分页，请设置分页对象，
     * 如：entity.setPage(new Page<T>());
     * @param entity
     * @return
     */
    public List<OaNotify> findList(OaNotify entity);
    public Page<OaNotify> find(Page<OaNotify> page, OaNotify oaNotify);
    /**
     * 获取通知发送记录
     * @param oaNotify
     * @return
     */
    public OaNotify getRecordList(OaNotify oaNotify);
    public void save(OaNotify oaNotify);
    public void delete(OaNotify entity);
    /**
     * 更新阅读状态
     */
    public void updateReadFlag(OaNotify oaNotify);
    /**
     * 获取通知数目
     * @param oaNotify
     * @return
     */
    public Long findCount(OaNotify oaNotify);
}
