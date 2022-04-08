package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.Collect;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.CollectService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 收藏模块
 * @Date: 2021/11/9 22:07
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    /**
     * @api {post} /collect/add 进行收藏
     * @apiVersion 0.0.1
     * @apiDescription  用户收藏回答/文章/想法的接口，ps：一个对象可以被收藏进多个收藏夹
     * @apiGroup 收藏-collect
     * @apiParam(入参) {int} userId 收藏用户id，必填
     * @apiParam(入参) {int} moduleCode 被收藏对象类型：1：回答；2：文章；3：想法；必填
     * @apiParam(入参) {int} moduleId 被收藏对象id，对应于answerId/articleId/ideaId，必填
     * @apiParam(入参) {int} favoritesId 收藏夹id，必填
     * @apiParamExample {json} 入参样例：
     * {
     *     "userId": 1,
     *     "moduleCode": 1,
     *     "moduleId": 1,
     *     "favoritesId": 1
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
     *         "collectId": 1,
     *         "userId": 1,
     *         "moduleCode": 1,
     *         "moduleId": 1,
     *         "favoritesId": 1,
     *         "mark": null,
     *         "createTime": "2021-11-10 15:12:48",
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
    public CommonResult addCollect(@RequestBody String json){
        log.info("addCollect==>"+json);
        //转化为实体类
        Collect collect = JSON.parseObject(json, Collect.class);
        return collectService.insertSelective(collect);
    }

    /**
     * @api {get} /collect/selectList?userId=1&moduleCode=1&moduleId=1 查询收藏
     * @apiVersion 0.0.1
     * @apiDescription  查询用户收藏某回答/文章/想法的情况
     * @apiGroup 收藏-collect
     * @apiParam(入参) {int} userId 收藏用户id，必填
     * @apiParam(入参) {int} moduleCode 被收藏对象类型：1：回答；2：文章；3：想法；必填
     * @apiParam(入参) {int} moduleId 被收藏对象id，对应于answerId/articleId/ideaId，必填
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
     *         "collectList": [
     *             {
     *                 "collectId": 1,
     *                 "userId": 1,
     *                 "moduleCode": 1,
     *                 "moduleId": 1,
     *                 "favoritesId": 1,
     *                 "mark": null,
     *                 "createTime": "2021-11-10 15:10:28.0",
     *                 "isDelete": false
     *             },
     *             {
     *                 "collectId": 3,
     *                 "userId": 1,
     *                 "moduleCode": 1,
     *                 "moduleId": 1,
     *                 "favoritesId": 2,
     *                 "mark": null,
     *                 "createTime": null,
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
    public CommonResult selectListCollect(@RequestParam int userId, int moduleCode, int moduleId) throws Exception{
        log.info("selectListCollect_userId==>"+userId);
        log.info("selectListCollect_moduleCode==>"+moduleCode);
        log.info("selectListCollect_moduleId==>"+moduleId);
        return collectService.selectAllCollect(userId, moduleCode, moduleId);
    }

    /**
     * @api {get} /collect/delete?collectId=4 取消收藏
     * @apiVersion 0.0.1
     * @apiDescription  取消收藏，真删除关系。
     * @apiGroup 收藏-collect
     * @apiParam(入参) {int} collectId 收藏关系id（查询收藏时返回），必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-调用成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} data 取消操作4成功/取消操作1不存在
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "调用成功",
     *     "data": "取消收藏1成功"
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
    public CommonResult deleteCollect(@RequestParam int collectId) throws Exception{
        log.info("deleteCollect==>"+collectId);
        return collectService.deleteByPrimaryKey(collectId);
    }
}
