package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.OneTagId;
import cn.edu.guet.exchange.entities.TagOwner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/5 20:56
 * @Version: 1.0
 */
@Mapper
public interface TagOwnerMapper {
    int deleteByPrimaryKey(Integer tagOwnerId);

    int insert(TagOwner record);

    int insertSelective(TagOwner record);

    TagOwner selectByPrimaryKey(Integer tagOwnerId);

    int updateByPrimaryKeySelective(TagOwner record);

    int updateByPrimaryKey(TagOwner record);

    /**
     * 根据文章id查询该文章的标签信息
     * @param articleId
     * @param moduleCode
     * @return
     */
    List<Integer> selectTagByArticleId(@Param("articleId") Integer articleId, @Param("moduleCode") Integer moduleCode);

    /**
     * 根据问题id查询该问题的标签信息
     * @param problemId
     * @param moduleCode
     * @return
     */
    List<Integer> selectTagByProblemId(@Param("problemId") Integer problemId, @Param("moduleCode") Integer moduleCode);

}