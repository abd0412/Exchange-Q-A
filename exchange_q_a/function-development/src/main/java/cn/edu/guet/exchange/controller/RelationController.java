package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Relation;
import cn.edu.guet.exchange.service.RelationService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 用户与对象的关系管理:
 * 问题：1：关注问题；2：邀请回答；3：好问题；
 * 回答：1：赞同；2：不赞同；3：收藏；4：喜欢；
 * 评论：1：赞；2：踩；
 * 文章：1：赞同；2：不赞同；3：收藏；4：喜欢；5：已转载；
 * 想法：1：鼓掌；2：收藏；
 * 其他用户：1：关注；
 * 其他用户的收藏夹：1：关注
 * @Date: 2021/11/8 15:13
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/relation")
public class RelationController {
    @Resource
    private RelationService relationService;
    /**
     * @api {post} /relation/add 添加操作
     * @apiVersion 0.0.1
     * @apiDescription  该接口应用于：添加登录的用户对问题/回答/评论/文章/想法/其他用户/其他用户的收藏夹7个对象进行的单项操作，操作以单项的形式进行叠加，不包含邀请回答和收藏。
     * @apiGroup 操作-Relation
     * @apiParam(入参) {int} userId 登录用户的id（系统生成唯一，在用户登录时返回），必填
     * @apiParam(入参) {int} moduleCode 登录用户对什么类型的对象进行了操作：1：problem；2：answer；3：comment；4：article； 5：idea；6：user；7：favorites，必填
     * @apiParam(入参) {int} moduleId 操作对象id(problemId/answerId/commentId/articleId/ideaId/userId/favoritesId)，必填
     * @apiParam(入参) {int} relationType 用户对对象的操作类型：
     * 问题：（1：关注问题；2：好问题；）
     * 回答：（1：赞同；2：不赞同；3：喜欢；）
     * 评论：（1：赞；2：踩；）
     * 文章：（1：赞同；2：不赞同；3：喜欢；4：已转载；）
     * 想法：（1：鼓掌；）
     * 其他用户：（1：关注；）
     * 其他用户的收藏夹：（1：关注；）
     * @apiParamExample {json} 入参样例：
     * {
     *     "userId": 1,
     *     "moduleCode": 1,
     *     "moduleId": 1,
     *     "relationType": 1
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-添加成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 添加对象
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "操作成功",
     *     "data": {
     *         "relationId": 18,
     *         "userId": 1,
     *         "moduleCode": 1,
     *         "moduleId": 1,
     *         "relationType": 1,
     *         "mark": null,
     *         "createTime": "2021-11-08 22:49:55",
     *         "updateTime": null,
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
    public CommonResult addRelation(@RequestBody String json) throws Exception{
        log.info("addRelation==>"+json);
        //转化为实体类
        Relation relation = JSON.parseObject(json, Relation.class);
        return relationService.insertSelective(relation);
    }

    /**
     * @api {get} /relation/select?userId=1&moduleCode=1&moduleId=1 查询操作
     * @apiVersion 0.0.1
     * @apiDescription  查询用户操作（不包含邀请回答和收藏），用于前端页面显示用户操作，userId为必填，其它选填。eg：userId=1&moduleCode=1&moduleId=1，释义：查询用户1对问题1的所有操作。
     * @apiGroup 操作-Relation
     * @apiParam(入参) {int} userId 登录用户的id（系统生成唯一，在用户登录时返回），必填
     * @apiParam(入参) {int} moduleCode 对象类型，1：problem；2：answer；3：comment；4：article； 5：idea；6：user；7：favorites；
     * @apiParam(入参) {int} moduleId 对象id
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 查询对象，释义：用户1对问题1有两个操作分别是关注了问题、认为是好问题。
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "relationList": [
     *             {
     *                 "relationId": 1,
     *                 "userId": 1,
     *                 "moduleCode": 1,
     *                 "moduleId": 1,
     *                 "relationType": 2,
     *                 "mark": null,
     *                 "createTime": "2021-11-08 17:05:16.0",
     *                 "updateTime": null,
     *                 "isDelete": false
     *             },
     *             {
     *                 "relationId": 12,
     *                 "userId": 1,
     *                 "moduleCode": 1,
     *                 "moduleId": 1,
     *                 "relationType": 1,
     *                 "mark": null,
     *                 "createTime": "2021-11-08 20:11:14.0",
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
    @GetMapping(value = "/select")
    public CommonResult selectRelation(@RequestParam int userId, Integer moduleCode, Integer moduleId) throws Exception{
        log.info("selectRelation_userId==>"+userId);
        log.info("selectRelation_moduleCode==>"+moduleCode);
        log.info("selectRelation_moduleId==>"+moduleId);
        return relationService.selectObjectRelation(userId, moduleCode, moduleId);
    }

    /**
     * @api {get} /relation/delete?relationId=4 取消操作
     * @apiVersion 0.0.1
     * @apiDescription  取消单项操作，真删除关系。
     * @apiGroup 操作-Relation
     * @apiParam(入参) {int} relationId 操作id（添加时返回），必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-调用成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} data 取消操作4成功/取消操作1不存在
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "调用成功",
     *     "data": "取消操作4成功"
     * }
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": 2001,
     *     "message": "数据库执行有异常",
     *     "data": null
     * }
     * @return
     */
    @GetMapping(value = "/delete")
    public CommonResult deleteComment(@RequestParam int relationId) throws Exception{
        log.info("deleteComment==>"+relationId);
        return relationService.deleteByPrimaryKey(relationId);
    }
}
