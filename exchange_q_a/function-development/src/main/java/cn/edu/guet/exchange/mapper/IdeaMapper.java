package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Idea;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/6 23:01
 * @Version:    1.0
 */
@Mapper
public interface IdeaMapper {
    int deleteByPrimaryKey(Integer ideaId);

    int insert(Idea record);

    int insertSelective(Idea record);

    Idea selectByPrimaryKey(Integer ideaId);

    int updateByPrimaryKeySelective(Idea record);

    int updateByPrimaryKey(Idea record);
}