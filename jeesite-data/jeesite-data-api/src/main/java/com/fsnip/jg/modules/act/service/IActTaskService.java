package com.fsnip.jg.modules.act.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.modules.act.entity.Act;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 流程定义相关Service
 * Created by tanfy on 2017/5/15 0015.
 */
public interface IActTaskService {
    /**
     * 获取待办列表
     * @param procDefKey 流程定义标识
     * @return
     */
    public List<Act> todoList(Act act);
    /**
     * 获取已办任务
     * @param page
     * @param procDefKey 流程定义标识
     * @return
     */
    public Page<Act> historicList(Page<Act> page, Act act);
    /**
     * 获取流转历史列表
     * @param procInsId 流程实例
     * @param startAct 开始活动节点名称
     * @param endAct 结束活动节点名称
     */
    public List<Act> histoicFlowList(String procInsId, String startAct, String endAct);
    /**
     * 获取流程列表
     * @param category 流程分类
     */
    public Page<Object[]> processList(Page<Object[]> page, String category);
    /**
     * 获取流程表单（首先获取任务节点表单KEY，如果没有则取流程开始节点表单KEY）
     * @return
     */
    public String getFormKey(String procDefId, String taskDefKey);
    /**
     * 获取流程实例对象
     * @param procInsId
     * @return
     */
    public ProcessInstance getProcIns(String procInsId);
    /**
     * 启动流程
     * @param procDefKey 流程定义KEY
     * @param businessTable 业务表表名
     * @param businessId	业务表编号
     * @return 流程实例ID
     */
    public String startProcess(String procDefKey, String businessTable, String businessId) ;
    /**
     * 启动流程
     * @param procDefKey 流程定义KEY
     * @param businessTable 业务表表名
     * @param businessId	业务表编号
     * @param title			流程标题，显示在待办任务标题
     * @return 流程实例ID
     */
    public String startProcess(String procDefKey, String businessTable, String businessId, String title) ;
    /**
     * 签收任务
     * @param taskId 任务ID
     * @param userId 签收用户ID（用户登录名）
     */
    public void claim(String taskId, String userId);
    /**
     * 提交任务, 并保存意见
     * @param taskId 任务ID
     * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
     * @param comment 任务提交意见的内容
     * @param vars 任务变量
     */
    @Transactional(readOnly = false)
    public void complete(String taskId, String procInsId, String comment, Map<String, Object> vars);
    /**
     * 读取带跟踪的图片
     * @param executionId	环节ID
     * @return	封装了各种节点信息
     */
    public InputStream tracePhoto(String processDefinitionId, String executionId);
    /**
     * 流程跟踪图信息
     * @param processInstanceId		流程实例ID
     * @return	封装了各种节点信息
     */
    public List<Map<String, Object>> traceProcess(String processInstanceId) throws Exception;
    /**
     * 删除任务
     * @param taskId 任务ID
     * @param deleteReason 删除原因
     */
    public void deleteTask(String taskId, String deleteReason);
    }
