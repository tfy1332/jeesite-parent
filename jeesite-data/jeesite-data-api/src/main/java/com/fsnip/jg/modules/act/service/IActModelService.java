package com.fsnip.jg.modules.act.service;

import com.fsnip.jg.common.persistence.Page;
import org.activiti.engine.repository.Model;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 流程定义相关Service
 * Created by tanfy on 2017/5/15 0015.
 */
public interface IActModelService {
    /**
     * 流程模型列表
     */
    public Page<Model> modelList(Page<Model> page, String category);
    /**
     * 创建模型
     * @throws UnsupportedEncodingException
     */
    public Model create(String name, String key, String description, String category) throws UnsupportedEncodingException ;
    /**
     * 根据Model部署流程
     */
    public String deploy(String id);
    /**
     * 更新Model分类
     */
    public void updateCategory(String id, String category);
    /**
     * 删除模型
     * @param id
     * @return
     */
    public void delete(String id);
    /**
     * 导出model的xml文件
     * @throws IOException
     * @throws JsonProcessingException
     */
    public void export(String id, HttpServletResponse response);
    }
