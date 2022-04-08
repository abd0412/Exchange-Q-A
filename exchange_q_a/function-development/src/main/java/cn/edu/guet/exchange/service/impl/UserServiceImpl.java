package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.User;
import cn.edu.guet.exchange.mapper.UserMapper;
import cn.edu.guet.exchange.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 用户管理
 * @Date: 2021/11/6 21:38
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public CommonResult selectByPrimaryKey(Integer userId) {
        User user;
        try{
            user = userMapper.selectByPrimaryKey(userId);
        } catch(Exception e) {
            log.error("查询用户出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", user);
    }
}
