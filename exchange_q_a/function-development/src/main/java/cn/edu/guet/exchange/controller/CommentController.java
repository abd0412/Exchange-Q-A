package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.Article;
import cn.edu.guet.exchange.entities.Comment;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.CommentService;
import com.alibaba.fastjson.JSON;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 评论模块
 * @Date: 2021/11/6 10:32
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    /**
     * @api {post} /comment/add 添加评论
     * @apiVersion 0.0.1
     * @apiDescription  在问题/回答/评论/文章/想法下添加评论
     * @apiGroup 评论-Comment
     * @apiParam(入参) {int} userId 给与评论的用户id（系统生成唯一，在用户登录时返回），必填
     * @apiParam(入参) {String} commentContent 评论内容，必填
     * @apiParam(入参) {int} moduleCode 评论针对的对象类型，1：problem；2：answer；3：comment；4：article；5：idea；必填。PS：针对回答和文章做评论时，需要查阅评论权限再提交评论。
     * @apiParam(入参) {int} moduleId 评论所针对的对象的id，必填
     * @apiParam(入参) {int} rootModuleCode 评论的源头类型：1：problem；2：answer；3：article；4：idea；用于评论计数，必填
     * @apiParam(入参) {int} rootModuleId 评论的源头id，用于评论计数，必填
     * @apiParam(入参) {int} rootCommentId 根评论id，用于回复计数，当评论为回复类型时，必填
     * @apiParamExample {json} 入参样例：
     * {
     *     "userId": 3,
     *     "commentContent": "用户3对评论50的回复",
     *     "moduleCode": 3,
     *     "moduleId": 50,
     *     "rootModuleCode": 1,
     *     "rootModuleId": 1,
     *     "rootCommentId": 49
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-添加成功；2001-数据库执行有异常；1201-缺少评论的源头类型；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} data 添加对象
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "添加成功",
     *     "data": {
     *         "commentId": 52,
     *         "userId": 3,
     *         "commentContent": "用户3对评论50的回复",
     *         "moduleCode": 3,
     *         "moduleId": 50,
     *         "approvalNumber": null,
     *         "mark": null,
     *         "createTime": "2021-11-17 10:52:49",
     *         "updateTime": null,
     *         "isDelete": null,
     *         "subCommentList": null,
     *         "rootModuleCode": 1,
     *         "rootModuleId": 1,
     *         "rootCommentId": 49,
     *         "responseNumber": null
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
    public CommonResult addComment(@RequestBody String json) throws Exception{
        log.info("addCommentJson==>"+json);
        //转化为实体类
        Comment comment = JSON.parseObject(json, Comment.class);
        return commentService.insertSelective(comment);
    }

    /**
     * @api {get} /comment/delete?commentId=49 删除评论
     * @apiVersion 0.0.1
     * @apiDescription  根据评论id逻辑删除该条评论，并做逻辑级联删除。
     * @apiGroup 评论-Comment
     * @apiParam(入参) {int} commentId 评论id，必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-调用成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} data 删除评论x成功/删除评论x不存在
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "调用成功",
     *     "data": "级联删除评论49成功"
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
    public CommonResult deleteComment(@RequestParam Integer commentId) throws Exception{
        log.info("deleteComment_commentId==>"+commentId);
        return commentService.dummyDeleteByPrimaryKey(commentId);
    }

    /**
     * @api {get} /comment/root_selectList?moduleCode=2&moduleId=7&pageNumber=1&pageLength=10 查询根评论
     * @apiVersion 0.0.1
     * @apiDescription  查询问题/回答/评论/文章/想法下的根评论及其两个子评论，用于初级显示。
     * @apiGroup 评论-Comment
     * @apiParam(入参) {int} moduleCode 评论针对的对象类型，1：problem；2：answer；4：article；5：idea；必填。
     * @apiParam(入参) {int} moduleId 评论所针对的对象的id， 必填
     * @apiParam(入参) {int} pageNumber 页码，必填
     * @apiParam(入参) {int} pageLength 页面长度，必填，唯一限定某一值
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-调用成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} data 查询对象
     * @apiSuccess(出参) {array} responseList 第一层评论和其两个子评论
     * @apiSuccess(出参) {int} totalPages 分页数
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "responseList": [
     *             {
     *                 "comment": {
     *                     "commentId": 49,
     *                     "userId": 1,
     *                     "commentContent": "用户1对回答7的评论",
     *                     "moduleCode": 2,
     *                     "moduleId": 7,
     *                     "approvalNumber": 0,
     *                     "mark": null,
     *                     "createTime": "2021-11-17 10:48:24.0",
     *                     "updateTime": null,
     *                     "isDelete": false,
     *                     "subCommentList": [
     *                         {
     *                             "comment": {
     *                                 "commentId": 50,
     *                                 "userId": 2,
     *                                 "commentContent": "用户2对评论49的回复",
     *                                 "moduleCode": 3,
     *                                 "moduleId": 49,
     *                                 "approvalNumber": 0,
     *                                 "mark": null,
     *                                 "createTime": "2021-11-17 10:49:53.0",
     *                                 "updateTime": null,
     *                                 "isDelete": false,
     *                                 "subCommentList": null,
     *                                 "rootModuleCode": 2,
     *                                 "rootModuleId": 7,
     *                                 "rootCommentId": 49,
     *                                 "responseNumber": 0
     *                             },
     *                             "replyUser": {
     *                                 "userId": 2,
     *                                 "account": "qinshuo2",
     *                                 "password": "000000",
     *                                 "name": "秦硕",
     *                                 "sex": 0,
     *                                 "introduce": null,
     *                                 "address": null,
     *                                 "industry": null,
     *                                 "profession": null,
     *                                 "education": null,
     *                                 "authentication": null,
     *                                 "briefIntroduction": null,
     *                                 "headLogo": "http://10.12.0.158:8383/imagesUpload/b5abc5df-2f22-4449-ae80-1855977aaaa8.jpg",
     *                                 "followerNumber": 3,
     *                                 "mark": null,
     *                                 "createTime": "2021-11-05 21:24:17.0",
     *                                 "updateTime": null,
     *                                 "isDelete": false
     *                             },
     *                             "beRepliedUser": {
     *                                 "userId": 1,
     *                                 "account": "lihaopeng1",
     *                                 "password": "000000",
     *                                 "name": "李浩鹏",
     *                                 "sex": 0,
     *                                 "introduce": null,
     *                                 "address": null,
     *                                 "industry": null,
     *                                 "profession": null,
     *                                 "education": null,
     *                                 "authentication": null,
     *                                 "briefIntroduction": null,
     *                                 "headLogo": "http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg",
     *                                 "followerNumber": 0,
     *                                 "mark": null,
     *                                 "createTime": "2021-11-02 17:18:38.0",
     *                                 "updateTime": null,
     *                                 "isDelete": false
     *                             }
     *                         },
     *                         {
     *                             "comment": {
     *                                 "commentId": 51,
     *                                 "userId": 3,
     *                                 "commentContent": "用户3对评论49的回复",
     *                                 "moduleCode": 3,
     *                                 "moduleId": 49,
     *                                 "approvalNumber": 0,
     *                                 "mark": null,
     *                                 "createTime": "2021-11-17 10:51:55.0",
     *                                 "updateTime": null,
     *                                 "isDelete": false,
     *                                 "subCommentList": null,
     *                                 "rootModuleCode": 2,
     *                                 "rootModuleId": 7,
     *                                 "rootCommentId": 49,
     *                                 "responseNumber": 0
     *                             },
     *                             "replyUser": {
     *                                 "userId": 3,
     *                                 "account": "wangting3",
     *                                 "password": "000000",
     *                                 "name": "王婷",
     *                                 "sex": 1,
     *                                 "introduce": null,
     *                                 "address": null,
     *                                 "industry": null,
     *                                 "profession": null,
     *                                 "education": null,
     *                                 "authentication": null,
     *                                 "briefIntroduction": null,
     *                                 "headLogo": "http://10.12.0.158:8383/imagesUpload/9d7765b3-5489-47e8-9218-71c011e2bea1.jpg",
     *                                 "followerNumber": 1,
     *                                 "mark": null,
     *                                 "createTime": "2021-11-06 15:54:09.0",
     *                                 "updateTime": null,
     *                                 "isDelete": false
     *                             },
     *                             "beRepliedUser": {
     *                                 "userId": 1,
     *                                 "account": "lihaopeng1",
     *                                 "password": "000000",
     *                                 "name": "李浩鹏",
     *                                 "sex": 0,
     *                                 "introduce": null,
     *                                 "address": null,
     *                                 "industry": null,
     *                                 "profession": null,
     *                                 "education": null,
     *                                 "authentication": null,
     *                                 "briefIntroduction": null,
     *                                 "headLogo": "http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg",
     *                                 "followerNumber": 0,
     *                                 "mark": null,
     *                                 "createTime": "2021-11-02 17:18:38.0",
     *                                 "updateTime": null,
     *                                 "isDelete": false
     *                             }
     *                         }
     *                     ],
     *                     "rootModuleCode": 2,
     *                     "rootModuleId": 7,
     *                     "rootCommentId": null,
     *                     "responseNumber": 4
     *                 },
     *                 "replyUser": {
     *                     "userId": 1,
     *                     "account": "lihaopeng1",
     *                     "password": "000000",
     *                     "name": "李浩鹏",
     *                     "sex": 0,
     *                     "introduce": null,
     *                     "address": null,
     *                     "industry": null,
     *                     "profession": null,
     *                     "education": null,
     *                     "authentication": null,
     *                     "briefIntroduction": null,
     *                     "headLogo": "http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg",
     *                     "followerNumber": 0,
     *                     "mark": null,
     *                     "createTime": "2021-11-02 17:18:38.0",
     *                     "updateTime": null,
     *                     "isDelete": false
     *                 },
     *                 "beRepliedUser": null
     *             },
     *             {
     *                 "comment": {
     *                     "commentId": 54,
     *                     "userId": 3,
     *                     "commentContent": "用户4对回答7的评论",
     *                     "moduleCode": 2,
     *                     "moduleId": 7,
     *                     "approvalNumber": 0,
     *                     "mark": null,
     *                     "createTime": "2021-11-17 19:07:02.0",
     *                     "updateTime": null,
     *                     "isDelete": false,
     *                     "subCommentList": [],
     *                     "rootModuleCode": 2,
     *                     "rootModuleId": 7,
     *                     "rootCommentId": null,
     *                     "responseNumber": 0
     *                 },
     *                 "replyUser": {
     *                     "userId": 3,
     *                     "account": "wangting3",
     *                     "password": "000000",
     *                     "name": "王婷",
     *                     "sex": 1,
     *                     "introduce": null,
     *                     "address": null,
     *                     "industry": null,
     *                     "profession": null,
     *                     "education": null,
     *                     "authentication": null,
     *                     "briefIntroduction": null,
     *                     "headLogo": "http://10.12.0.158:8383/imagesUpload/9d7765b3-5489-47e8-9218-71c011e2bea1.jpg",
     *                     "followerNumber": 1,
     *                     "mark": null,
     *                     "createTime": "2021-11-06 15:54:09.0",
     *                     "updateTime": null,
     *                     "isDelete": false
     *                 },
     *                 "beRepliedUser": null
     *             }
     *         ],
     *         "totalPages": 1
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
    @GetMapping(value = "/root_selectList")
    public CommonResult rootSelectListComment(@RequestParam int moduleCode, int moduleId, int pageNumber, int pageLength) throws Exception{
        log.info("selectListComment_moduleCode==>"+moduleCode);
        log.info("selectListComment_moduleId==>"+moduleId);
        log.info("selectListComment_pageNumber==>"+pageNumber);
        log.info("selectListComment_pageLength==>"+pageLength);
        return commentService.selectAllComment(moduleCode, moduleId, pageNumber, pageLength);
    }

    /**
     * @api {get} /comment/child_selectList?moduleId=49&pageNumber=1&pageLength=4 查询子评论
     * @apiVersion 0.0.1
     * @apiDescription  分页查询评论下的回复
     * @apiGroup 评论-Comment
     * @apiParam(入参) {int} moduleId 被回复的评论id， 必填
     * @apiParam(入参) {int} pageNumber 页码，必填
     * @apiParam(入参) {int} pageLength 页面长度，必填，唯一限定某一值
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-调用成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} data 查询对象
     * @apiSuccess(出参) {array} responseList 根评论下的回复
     * @apiSuccess(出参) {int} totalPages 分页数
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "responseList": [
     *             {
     *                 "comment": {
     *                     "commentId": 50,
     *                     "userId": 2,
     *                     "commentContent": "用户2对评论49的回复",
     *                     "moduleCode": 3,
     *                     "moduleId": 49,
     *                     "approvalNumber": 0,
     *                     "mark": null,
     *                     "createTime": "2021-11-17 10:49:53.0",
     *                     "updateTime": null,
     *                     "isDelete": false,
     *                     "subCommentList": null,
     *                     "rootModuleCode": 2,
     *                     "rootModuleId": 7,
     *                     "rootCommentId": 49,
     *                     "responseNumber": 0
     *                 },
     *                 "replyUser": {
     *                     "userId": 2,
     *                     "account": "qinshuo2",
     *                     "password": "000000",
     *                     "name": "秦硕",
     *                     "sex": 0,
     *                     "introduce": null,
     *                     "address": null,
     *                     "industry": null,
     *                     "profession": null,
     *                     "education": null,
     *                     "authentication": null,
     *                     "briefIntroduction": null,
     *                     "headLogo": "http://10.12.0.158:8383/imagesUpload/b5abc5df-2f22-4449-ae80-1855977aaaa8.jpg",
     *                     "followerNumber": 3,
     *                     "mark": null,
     *                     "createTime": "2021-11-05 21:24:17.0",
     *                     "updateTime": null,
     *                     "isDelete": false
     *                 },
     *                 "beRepliedUser": {
     *                     "userId": 1,
     *                     "account": "lihaopeng1",
     *                     "password": "000000",
     *                     "name": "李浩鹏",
     *                     "sex": 0,
     *                     "introduce": null,
     *                     "address": null,
     *                     "industry": null,
     *                     "profession": null,
     *                     "education": null,
     *                     "authentication": null,
     *                     "briefIntroduction": null,
     *                     "headLogo": "http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg",
     *                     "followerNumber": 0,
     *                     "mark": null,
     *                     "createTime": "2021-11-02 17:18:38.0",
     *                     "updateTime": null,
     *                     "isDelete": false
     *                 }
     *             }
     *         ],
     *         "totalPages": 4
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
    @GetMapping(value = "/child_selectList")
    public CommonResult childSelectListComment(@RequestParam int moduleId, int pageNumber, int pageLength) throws Exception{
        log.info("selectListComment_moduleId==>"+moduleId);
        log.info("selectListComment_pageNumber==>"+pageNumber);
        log.info("selectListComment_pageLength==>"+pageLength);
        return commentService.selectChildComment(moduleId, pageNumber, pageLength);
    }
}
