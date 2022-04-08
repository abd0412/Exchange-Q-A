package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/8 20:27
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}