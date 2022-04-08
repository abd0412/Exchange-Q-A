package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 登录
 * @Date: 2021/11/3 14:32
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/account")
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * @api {post} /account/login 用户登录
     * @apiVersion 0.0.1
     * @apiDescription  用户登录接口，通过账号和密码登录，账号为系统分配，默认密码000000，可支持修改和忘记密码。
     * @apiGroup 登录-Login
     * @apiParam(入参) {String} account 用户登录账号，唯一，系统分配（lihaopeng1  000000）。
     * @apiParam(入参) {String} password 密码，初始密码为000000。
     * @apiParamExample {json} 入参样例：
     * {
     *     "account": "lihaopeng1",
     *     "password": "000000"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-验证成功；1201-无此用户，验证失败；1202-密码错误，验证失败；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {JSONObject} data 用户相关信息
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "验证成功",
     *     "data": {
     *         "userId": 1,
     *         "userName": "李浩鹏",
     *         "password": "000000",
     *         "sex": 0,
     *         "introduce": null,
     *         "address": null,
     *         "industry": null,
     *         "profession": null,
     *         "education": null,
     *         "authentication": null,
     *         "briefIntroduction": null,
     *         "headLogo": null,
     *         "mark": null,
     *         "createTime": "2021-11-02T09:18:38.000+0000",
     *         "updateTime": null,
     *         "isDelete": false,
     *         "account": "lihaopeng1"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": 1201,
     *     "message": "无此用户，验证失败",
     *     "data": null
     * }
     * @return
     */

    @PostMapping(value = "/login")
    public CommonResult userLogin(@RequestBody String json) throws Exception{
        log.info("userLoginJson==>"+json);
        return loginService.loginCheck(json);
    }
}
