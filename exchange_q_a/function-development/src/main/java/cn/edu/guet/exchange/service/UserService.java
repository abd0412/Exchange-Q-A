package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.User;

/**
 * @Author: cyan
 * @Description: 用户管理
 * @Date: 2021/11/6 21:37
 * @Version: 1.0
 */
public interface UserService {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    CommonResult selectByPrimaryKey(Integer userId);
}
