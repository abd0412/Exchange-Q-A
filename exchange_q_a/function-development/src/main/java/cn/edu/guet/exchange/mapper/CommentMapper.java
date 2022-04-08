package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/6 14:41
 * @Version: 1.0
 */
@Mapper
public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * 逻辑删除
     * @param commentId
     * @return
     */
    int dummyDeleteByPrimaryKey(Integer commentId);

    /**
     * 根据入参分页查找第一层评论
     * @param moduleCode
     * @param moduleId
     * @return
     */
    List<Comment> selectCommentByModuleCodeModuleId(@Param("moduleCode") Integer moduleCode, @Param("moduleId") Integer moduleId, @Param("lineNumber") Integer lineNumber, @Param("pageLength") Integer pageLength);

    /**
     * 统计评论数量
     * @param moduleCode
     * @param moduleId
     * @return
     */
    int selectCommentNumberByModuleCodeModuleId(@Param("moduleCode") Integer moduleCode, @Param("moduleId") Integer moduleId);

    /**
     * 根据入参查找评论的评论
     * @param moduleCode
     * @param moduleId
     * @return
     */
    List<Comment> selectAllCommentByModuleCodeModuleId(@Param("moduleCode") Integer moduleCode, @Param("moduleId") Integer moduleId);

    /**
     * 查找回复
     * @param moduleId
     * @param lineNumber
     * @param pageLength
     * @return
     */
    List<Comment> selectResponseByModuleId(@Param("moduleId") Integer moduleId, @Param("lineNumber") Integer lineNumber, @Param("pageLength") Integer pageLength);

    /**
     * 查找被评论的人
     * @param beCommentedId
     * @return
     */
    Integer selectBeCommentedUserId(@Param("beCommentedId") Integer beCommentedId);

    List<Comment> selectChildComment(@Param("moduleCode") Integer moduleCode, @Param("commentId") Integer commentId);

}