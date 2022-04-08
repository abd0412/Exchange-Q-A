package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Problem;
import cn.edu.guet.exchange.service.ProblemService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 提问题模块
 * @Date: 2021/11/4 14:22
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/problem")
public class ProblemController {
    @Resource
    private ProblemService problemService;

    /**
     * @api {post} /problem/add 提交问题
     * @apiVersion 0.0.1
     * @apiDescription  用户提交问题的接口
     * @apiGroup 问题-Problem
     * @apiParam(入参) {int} userId 提问题的用户id（系统生成唯一，用户登录时返回），必填
     * @apiParam(入参) {String} problemDescribe 问题描述，带问号
     * @apiParam(入参) {text} problemDetails 输入问题背景、条件等详细信息（选填）
     * @apiParam(入参) {text} abbreviatedContent 收起的缩略内容
     * @apiParam(入参) {array} tagList 标签列表，至少带一个，带的话题是个标签，所属分类是话题
     * @apiParam(入参) {int} tagId 标签Id，值列表，需数据库中拥有。
     * @apiParam(入参) {boolean} isAnonymity 问题发布者是否匿名，0代表不生效（默认），1代表生效
     * @apiParamExample {json} 入参样例：
     * {
     *     "userId": 1,
     *     "problemDescribe": "有JAVA基础，学习前端需要多久？",
     *     "problemDetails": "<p>xxx</p >",
     *     "abbreviatedContent": "xxx",
     *     "tagList": [
     *             {
     *                 "tagId": 1
     *             },
     *             {
     *                  "tagId": 2
     *             }
     *         ],
     *     "isAnonymity": 1
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
     *         "problemId": 5,
     *         "userId": 1,
     *         "problemDescribe": "有JAVA基础，学习前端需要多久？",
     *         "problemDetails": "<p>xxx</p >",
     *         "browseNumber": null,
     *         "followerNumber": null,
     *         "goodQuestionNumber": null,
     *         "commentNumber": null,
     *         "answerNumber": null,
     *         "isAnonymity": true,
     *         "mark": null,
     *         "createTime": "2021-11-04 23:20:03",
     *         "updateTime": null,
     *         "isDelete": null,
     *         "abbreviatedContent": "xxx",
     *         "tagList": [
     *             {
     *                 "tagId": 1
     *             },
     *             {
     *                 "tagId": 2
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
    @PostMapping(value = "/add")
    public CommonResult addProblem(@RequestBody String json) throws Exception{
        log.info("addProblemJson==>"+json);
        //转化为实体类
        Problem problem = JSON.parseObject(json, Problem.class);
        return problemService.insert(problem);
    }

    /**
     * @api {get} /problem/selectList?category=1&pageNumber=1&pageLength=2&userId= 等你来答
     * @apiVersion 0.0.1
     * @apiDescription  根据分类分页获取平台所有相关分类问题
     * @apiGroup 问题-Problem
     * @apiParam(入参) {int} category 问题分类，1：人气问题；查询规则为：问题的关注人数+认为是好问题的人数+问题的评论个数+问题的回答个数的总和从高到低排序。 2：最新问题；查询规则为：发布时间。 3：邀请回答；为邀请回答的问题，根据用户id查询。
     * @apiParam(入参) {int} pageNumber 页码，必填
     * @apiParam(入参) {int} pageLength 页面长度，必填，唯一限定某一值
     * @apiParam(入参) {int} userId 用户id，查询该用户被邀请回答的问题(category=3)时使用，否则为null，即&userId=。返回的是邀请关系，再调用查询某问题接口显示问题详情。
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} problemList/problemInvitationList 回答列表/邀请关系列表
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功：页码1包含的所有问题信息",
     *     "data": {
     *         "problemList": [
     *             {
     *                 "problemId": 1,
     *                 "userId": 1,
     *                 "problemDescribe": "有JAVA基础，学习前端需要多久？",
     *                 "problemDetails": "<p>xxx</p >",
     *                 "browseNumber": 0,
     *                 "followerNumber": 0,
     *                 "goodQuestionNumber": 5,
     *                 "commentNumber": 0,
     *                 "answerNumber": 10,
     *                 "isAnonymity": true,
     *                 "mark": null,
     *                 "createTime": "2021-11-04 15:49:55.0",
     *                 "updateTime": null,
     *                 "isDelete": false,
     *                 "abbreviatedContent": "xxx",
     *                 "tagList": null
     *             },
     *             {
     *                 "problemId": 5,
     *                 "userId": 2,
     *                 "problemDescribe": "有JAVA基础，学习前端需要多久？",
     *                 "problemDetails": "<p>xxx</p >",
     *                 "browseNumber": 0,
     *                 "followerNumber": 0,
     *                 "goodQuestionNumber": 10,
     *                 "commentNumber": 0,
     *                 "answerNumber": 0,
     *                 "isAnonymity": true,
     *                 "mark": null,
     *                 "createTime": "2021-11-04 23:20:03.0",
     *                 "updateTime": null,
     *                 "isDelete": false,
     *                 "abbreviatedContent": "xxx",
     *                 "tagList": null
     *             }
     *         ]
     *     }
     * }
     *
     * @apiSuccessExample {json} 返回成功样例（某用户被邀请回答的关系）：
     * {
     *     "code": 200,
     *     "message": "查询成功：页码1包含的邀请回答信息",
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
     *                 "questionsInviteesId": 3,
     *                 "problemId": 2,
     *                 "inviterId": 1,
     *                 "inviteeId": 2,
     *                 "updateTime": null,
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
    public CommonResult selectListProblem(@RequestParam int category, int pageNumber, int pageLength, Integer userId) throws Exception{
        log.info("selectListProblem_category==>" + category + "  pageNumber==>" + pageNumber + "  pageLength==》" + pageLength + "  userId==>" + userId);
        return problemService.selectProblemByCategory(category, pageNumber, pageLength, userId);
    }

    /**
     * @api {get} /problem/select?problemId=5 查询某问题
     * @apiVersion 0.0.1
     * @apiDescription  根据问题id获取该问题的所有信息
     * @apiGroup 问题-Problem
     * @apiParam(入参) {int} problemId 问题id，必填
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
     *         "problemId": 5,
     *         "userId": 2,
     *         "problemDescribe": "有JAVA基础，学习前端需要多久？",
     *         "problemDetails": "<p>xxx</p >",
     *         "browseNumber": 0,
     *         "followerNumber": 0,
     *         "goodQuestionNumber": 10,
     *         "commentNumber": 0,
     *         "answerNumber": 0,
     *         "isAnonymity": true,
     *         "mark": null,
     *         "createTime": "2021-11-04 23:20:03.0",
     *         "updateTime": null,
     *         "isDelete": false,
     *         "abbreviatedContent": "xxx",
     *         "tagList": [
     *             {
     *                 "tagId": 1
     *             },
     *             {
     *                 "tagId": 2
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
    @GetMapping(value = "/select")
    public CommonResult selectOneProblem(@RequestParam int problemId) throws Exception{
        log.info("selectOneProblem_problemId==>"+problemId);
        return problemService.selectOneProblemInfo(problemId);
    }
}
