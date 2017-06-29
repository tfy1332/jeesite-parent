package com.fsnip.jg.modules.oa.service.leave;


import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.oa.entity.Leave;

import java.util.List;
import java.util.Map;

/**
 * Created by tanfy on 2017/4/20 0020.
 * 请假Service
 */
public interface ILeaveService  extends IBaseService<Leave>{
    /**
     * 启动流程
     * @param entity
     */
    public void save(Leave leave, Map<String, Object> variables);
    /**
     * 查询待办任务
     * @param userId 用户ID
     * @return
     */
    public List<Leave> findTodoTasks(String userId);
    public Page<Leave> find(Page<Leave> page, Leave leave);
    /**
     * 获取流程详细及工作流参数
     * @param id
     */
    @SuppressWarnings("unchecked")
    public Leave get(String id);
}
