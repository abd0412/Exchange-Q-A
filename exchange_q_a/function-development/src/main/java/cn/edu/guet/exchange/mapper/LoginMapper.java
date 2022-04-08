package cn.edu.guet.exchange.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: cyan
 * @Description: 登录
 * @Date: 2021/11/3 15:59
 * @Version: 1.0
 */
@Mapper
public interface LoginMapper {
    /**
     * 在用户表中根据账号查找用户id
     * @param account
     * @return 用户id
     */
    Integer selectUserId(String account);
}
