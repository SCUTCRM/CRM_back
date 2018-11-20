package com.example.crm.dao;

import com.example.crm.entity.Comment;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/17 15:15
 * @ Description：评论数据库访问层接口
 * @ Modified By：
 */
@Component
public interface CommentDao {
    /**
     * create by: Bin Liu
     * description: 根据id获取指定评论信息
     * create time: 2018/11/17 15:18
     * @Param: null
     * @return
     */
    Comment getCommentById(Integer commentId);

    /**
     * create by: Bin Liu
     * description: 增加一个评论信息
     * create time: 2018/11/17 15:18
     * @Param: null
     * @return
     */
    int insertComment(Comment comment);

    /**
     * create by: Bin Liu
     * description: 更新一个评论
     * create time: 2018/11/17 15:18
     * @Param: null
     * @return
     */
    int updateComment(Comment comment);

    /**
     * create by: Bin Liu
     * description: 根据Id评论地址信息
     * create time: 2018/11/17 15:18
     * @Param: null
     * @return
     */
    int deleteComment(Integer commentId);
}
