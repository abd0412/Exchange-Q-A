package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.Answer;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.AnswerService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 回答
 * @Date: 2021/11/5 10:37
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/answer")
public class AnswerController {
    @Resource
    private AnswerService answerService;

    /**
     * @api {post} /answer/add 写回答
     * @apiVersion 0.0.1
     * @apiDescription  写回答的接口
     * @apiGroup 回答-Answer
     * @apiParam(入参) {int} problemId 问题id，必填
     * @apiParam(入参) {int} userId 回答的用户id，必填
     * @apiParam(入参) {text} answerContent 回答内容，必填
     * @apiParam(入参) {text} answerAbbreviatedContent 回答的收起的缩略内容
     * @apiParam(入参) {int} declare 创作声明，暂分类为：0：无声明（默认）; 1：虚假创作; 2: 包含理财内容; 3: 包含剧透；4：包含医疗建议;
     * @apiParam(入参) {boolean} isAnonymity 是否匿名，0：不匿名（默认）；1：匿名
     * @apiParam(入参) {string} introduce 一句话介绍
     * @apiParam(入参) {boolean} isPush 是否推送给关注者，0：不推；1：推送（默认）
     * @apiParam(入参) {boolean} isAllowed 是否允许转载，0：不允许; 1: 允许（默认）
     * @apiParam(入参) {boolean} isRestriction 是否限制评论，0：不限制（系统默认）; 1: 限制
     * @apiParam(入参) {int} restrictionType 限制类型，若限制开启则：1：允许我关注的人评论；2：答主筛选显示；3：禁止评论
     * @apiParamExample {json} 入参样例：
     * {
     *     "problemId": 1,
     *     "userId": 1,
     *     "answerContent": "<p>xxx</p >",
     *     "answerAbbreviatedContent": "xxx",
     *     "declare": 1,
     *     "isAnonymity": 1,
     *     "introduce": "",
     *     "isPush": 1,
     *     "isAllowed": 1,
     *     "isRestriction": 0
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-添加成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 添加的对象
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "添加成功",
     *     "data": {
     *         "answerId": 2,
     *         "problemId": 1,
     *         "userId": 1,
     *         "answerContent": "<p>xxx</p >",
     *         "declare": 1,
     *         "isAnonymity": true,
     *         "introduce": null,
     *         "isPush": true,
     *         "isAllowed": true,
     *         "isRestriction": false,
     *         "restrictionType": null,
     *         "agreeNumber": null,
     *         "disagreeNumber": null,
     *         "commentNumber": null,
     *         "mark": null,
     *         "createTime": "2021-11-05 15:38:58",
     *         "updateTime": null,
     *         "isDelete": null,
     *         "answerAbbreviatedContent": "xxx"
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
    public CommonResult addAnswer(@RequestBody String json) throws Exception{
        log.info("addAnswer==>"+json);
        //转化为实体类
        Answer answer = JSON.parseObject(json, Answer.class);
        return answerService.insert(answer);
    }

    /**
     * @api {get} /answer/selectList?problemId=1&pageNumber=1&pageLength=10 分页查询某问题的回答
     * @apiVersion 0.0.1
     * @apiDescription  根据问题id查询该问题的所有回答
     * @apiGroup 回答-Answer
     * @apiParam(入参) {int} problemId 问题id，必填
     * @apiParam(入参) {int} pageNumber 页码，必填
     * @apiParam(入参) {int} pageLength 页面长度，必填，唯一限定某一值
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} answerList 回答列表
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功：页码1包含的所有回答信息",
     *     "data": {
     *         "answerList": [
     *             {
     *                 "answerId": 1,
     *                 "problemId": 1,
     *                 "userId": 1,
     *                 "answerContent": "<p>xxx</p >",
     *                 "declare": 1,
     *                 "isAnonymity": true,
     *                 "introduce": null,
     *                 "isPush": true,
     *                 "isAllowed": true,
     *                 "isRestriction": false,
     *                 "restrictionType": null,
     *                 "agreeNumber": null,
     *                 "disagreeNumber": null,
     *                 "commentNumber": null,
     *                 "mark": null,
     *                 "createTime": "2021-11-05 15:24:46.0",
     *                 "updateTime": null,
     *                 "isDelete": false,
     *                 "answerAbbreviatedContent": null
     *             },
     *             {
     *                 "answerId": 2,
     *                 "problemId": 1,
     *                 "userId": 1,
     *                 "answerContent": "<p>xxx</p >",
     *                 "declare": 1,
     *                 "isAnonymity": true,
     *                 "introduce": null,
     *                 "isPush": true,
     *                 "isAllowed": true,
     *                 "isRestriction": false,
     *                 "restrictionType": null,
     *                 "agreeNumber": null,
     *                 "disagreeNumber": null,
     *                 "commentNumber": null,
     *                 "mark": null,
     *                 "createTime": "2021-11-05 15:38:58.0",
     *                 "updateTime": null,
     *                 "isDelete": false,
     *                 "answerAbbreviatedContent": "xxx"
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
    @GetMapping("/selectList")
    public CommonResult selectListAnswer(@RequestParam int problemId, int pageNumber, int pageLength) throws Exception {
        log.info("selectListAnswer_problemId==>"+problemId);
        return answerService.selectAnswerByProblemId(problemId, pageNumber, pageLength);
    }
}
