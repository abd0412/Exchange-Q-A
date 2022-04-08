package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.Comment;
import cn.edu.guet.exchange.entities.CommonResult;
import com.netflix.ribbon.proxy.annotation.Var;

/**
 * @Author: cyan
 * @Description: 评论
 * @Date: 2021/11/6 11:11
 * @Version: 1.0
 */
public interface CommentService {
    /**
     * 添加评论
     * @param record
     * @return
     */
    CommonResult insertSelective(Comment record);

    /**
     * 根据评论id删除评论
     * @param commentId
     * @return
     */
    CommonResult dummyDeleteByPrimaryKey(Integer commentId);

    /**
     * 查询根评论
     * @param moduleCode
     * @param moduleId
     * @param pageNumber
     * @param pageLength
     * @return
     */
    CommonResult selectAllComment(Integer moduleCode, Integer moduleId, Integer pageNumber, Integer pageLength);

    /**
     * 查询回复
     * @param moduleId
     * @param pageNumber
     * @param pageLength
     * @return
     */
    CommonResult selectChildComment(Integer moduleId, Integer pageNumber, Integer pageLength);
}
