package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.ProblemInvitation;
import cn.edu.guet.exchange.service.ProblemInvitationService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 邀请回答功能支持
 * @Date: 2021/11/9 13:45
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/invite")
public class ProblemInvitationController {
    @Resource
    private ProblemInvitationService problemInvitationService;
    /**
     * @api {post} /invite/add 添加邀请
     * @apiVersion 0.0.1
     * @apiDescription  邀请回答之添加邀请接口
     * @apiGroup 邀请回答-ProblemInvitation
     * @apiParam(入参) {int} problemId 问题id，必填
     * @apiParam(入参) {int} inviterId 邀请者(对应userId），必填
     * @apiParam(入参) {int} inviteeId 被邀请者（对应userId），必填
     * @apiParamExample {json} 入参样例：
     * {
     *     "problemId": 1,
     *     "inviterId": 1,
     *     "inviteeId": 2
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-添加成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 添加对象
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "添加成功",
     *     "data": {
     *         "questionsInviteesId": 1,
     *         "problemId": 1,
     *         "inviterId": 1,
     *         "inviteeId": 2,
     *         "updateTime": "2021-11-09 15:59:09",
     *         "isDelete": null
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
    @PostMapping(value = "/add")
    public CommonResult addInvite(@RequestBody String json) throws Exception{
        log.info("addInvite==>"+json);
        //转化为实体类
        ProblemInvitation problemInvitation = JSON.parseObject(json, ProblemInvitation.class);
        return problemInvitationService.insertSelective(problemInvitation);
    }

    /**
     * @api {get} /invite/selectList?inviterId=1&problemId=1 查询邀请
     * @apiVersion 0.0.1
     * @apiDescription  邀请回答之查询用户对此问题邀请了哪些人
     * @apiGroup 邀请回答-ProblemInvitation
     * @apiParam(入参) {int} inviterId 邀请者(对应userId），必填
     * @apiParam(入参) {int} problemId 问题id，必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-添加成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 查询列表
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "problemInvitationList": [
     *             {
     *                 "questionsInviteesId": 1,
     *                 "problemId": 1,
     *                 "inviterId": 1,
     *                 "inviteeId": 2,
     *                 "updateTime": "2021-11-09 15:59:09.0",
     *                 "isDelete": false
     *             },
     *             {
     *                 "questionsInviteesId": 2,
     *                 "problemId": 1,
     *                 "inviterId": 1,
     *                 "inviteeId": 3,
     *                 "updateTime": "2021-11-09 17:06:52.0",
     *                 "isDelete": false
     *             }
     *         ]
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
    @GetMapping(value = "/selectList")
    public CommonResult selectListInvite(@RequestParam int inviterId, int problemId) throws Exception{
        log.info("selectListInvite==>"+inviterId);
        log.info("selectListInvite==>"+problemId);
        //转化为实体类
        return problemInvitationService.selectAllInviteInfo(inviterId, problemId);
    }
}
