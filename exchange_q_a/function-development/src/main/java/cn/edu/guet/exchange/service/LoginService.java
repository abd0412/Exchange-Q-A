package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: cyan
 * @Description: 登录
 * @Date: 2021/11/3 14:36
 * @Version: 1.0
 */
public interface LoginService {
    /**
     * 登录校验方法
     * @param json
     * @return JSONObject
     */
    CommonResult loginCheck(String json);
}
