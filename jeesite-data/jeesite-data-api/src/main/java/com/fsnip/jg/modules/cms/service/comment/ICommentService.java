package com.fsnip.jg.modules.cms.service.comment;

import com.fsnip.jg.common.service.IBaseService;
import com.fsnip.jg.modules.cms.entity.Comment;

/**
 * 评论Service
 * Created by tanfy on 2017/5/12 0012.
 */
public interface ICommentService extends IBaseService<Comment> {
    public void delete(Comment entity, Boolean isRe);
}
