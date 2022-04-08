package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.Comment;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.mapper.UserMapper;
import cn.edu.guet.exchange.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 用户管理
 * @Date: 2021/11/6 13:17
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * @api {get} /user/select?userId=2 查询用户信息
     * @apiVersion 0.0.1
     * @apiDescription  根据用户id查询该用户的详细信息
     * @apiGroup 用户-User
     * @apiParam(入参) {int} userId 用户id，必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 查询对象
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "userId": 2,
     *         "name": "秦硕",
     *         "password": "000000",
     *         "sex": 0,
     *         "introduce": null,
     *         "address": null,
     *         "industry": null,
     *         "profession": null,
     *         "education": null,
     *         "authentication": null,
     *         "briefIntroduction": null,
     *         "headLogo": "http://10.12.0.158:8383/imagesUpload/b5abc5df-2f22-4449-ae80-1855977aaaa8.jpg",
     *         "mark": null,
     *         "createTime": "2021-11-05T13:24:17.000+0000",
     *         "updateTime": null,
     *         "isDelete": false,
     *         "account": "qinshuo2"
     *     }
     * }
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": 2001,
     *     "message": "数据库执行有异常",
     *     "data": null
     * }
     * @return
     */
    @GetMapping(value = "/select")
    public CommonResult selectUser(@RequestParam int userId) throws Exception{
        log.info("selectUser_userId==>"+userId);
        return userService.selectByPrimaryKey(userId);
    }
}
