package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.User;
import cn.edu.guet.exchange.mapper.LoginMapper;
import cn.edu.guet.exchange.mapper.UserMapper;
import cn.edu.guet.exchange.service.LoginService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 登录
 * @Date: 2021/11/3 15:18
 * @Version: 1.0
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public CommonResult loginCheck(String json) {
        JSONObject inputJsonObject = JSON.parseObject(json);
        String account = inputJsonObject.getString("account");
        String password = inputJsonObject.getString("password");
        try {
            int userId;
            if (loginMapper.selectUserId(account)==null){
                return new CommonResult(1201, "无此用户，验证失败", null);
            }else {
                userId = loginMapper.selectUserId(account);
            }

            User user = userMapper.selectByPrimaryKey(userId);
            String userPassword = user.getPassword();
            if(password.equals(userPassword)){
                return new CommonResult(200, "验证成功", user);
            }else {
                return new CommonResult(1202, "密码错误，验证失败", null);
            }

        } catch(Exception e) {
            log.error("出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
    }
}
