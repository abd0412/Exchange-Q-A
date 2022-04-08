package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/6 22:21
 * @Version: 1.0
 */
@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}