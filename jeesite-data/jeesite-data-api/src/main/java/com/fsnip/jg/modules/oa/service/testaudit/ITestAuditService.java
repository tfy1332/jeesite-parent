package com.fsnip.jg.modules.oa.service.testaudit;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.oa.entity.OaNotify;
import com.fsnip.jg.modules.oa.entity.TestAudit;

/**
 * Created by tanfy on 2017/4/20 0020.
 * 审批Service
 */
public interface ITestAuditService extends IBaseService<TestAudit> {
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public TestAudit get(String id);
    public Page<TestAudit> findPage(Page<TestAudit> page, TestAudit testAudit);
    /**
     * 审核新增或编辑
     * @param testAudit
     */
    public void save(TestAudit testAudit);
    /**
     * 审核审批保存
     * @param testAudit
     */
    public void auditSave(TestAudit testAudit);

    /**
     * 删除数据
     * @param entity
     */
    public void delete(TestAudit entity);
}
