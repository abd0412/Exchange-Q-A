package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.Answer;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Favorites;
import cn.edu.guet.exchange.service.FavoritesService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 收藏夹的管理
 * @Date: 2021/11/9 20:20
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/favorites")
public class FavoritesController {
    @Resource
    private FavoritesService favoritesService;
    /**
     * @api {post} /favorites/add 创建收藏夹
     * @apiVersion 0.0.1
     * @apiDescription  用户创建收藏夹的接口
     * @apiGroup 收藏夹-Favorites
     * @apiParam(入参) {int} userId 创建收藏夹的用户id，必填
     * @apiParam(入参) {String} favoritesTitle，收藏夹标题，必填，系统默认：我的收藏夹
     * @apiParam(入参) {String} favoritesDescribe 收藏夹描述，选填
     * @apiParam(入参) {boolean} isLimit 公开还是私密，0：公开（默认），1：私密
     * @apiParamExample {json} 入参样例：
     * {
     *     "userId": 1,
     *     "favoritesTitle": "考研资料",
     *     "favoritesDescribe": null,
     *     "isLimit": 0
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
     *         "favoritesId": 2,
     *         "userId": 1,
     *         "favoritesTitle": "考研资料",
     *         "favoritesDescribe": null,
     *         "isLimit": false,
     *         "contentNumber": null,
     *         "followerNumber": null,
     *         "mark": null,
     *         "createTime": "2021-11-09 20:55:57",
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
    public CommonResult addFavorites(@RequestBody String json){
        log.info("addFavorites==>"+json);
        //转化为实体类
        Favorites favorites = JSON.parseObject(json, Favorites.class);
        return favoritesService.insertSelective(favorites);
    }

    /**
     * @api {get} /favorites/selectList?userId=1 查询收藏夹
     * @apiVersion 0.0.1
     * @apiDescription  查询用户收藏夹的接口
     * @apiGroup 收藏夹-Favorites
     * @apiParam(入参) {int} userId 用户id，必填
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
     *         "favoritesList": [
     *             {
     *                 "favoritesId": 1,
     *                 "userId": 1,
     *                 "favoritesTitle": "我的收藏夹",
     *                 "favoritesDescribe": null,
     *                 "isLimit": false,
     *                 "contentNumber": 0,
     *                 "followerNumber": 1,
     *                 "mark": null,
     *                 "createTime": "2021-11-08 20:53:16.0",
     *                 "updateTime": null,
     *                 "isDelete": false
     *             },
     *             {
     *                 "favoritesId": 2,
     *                 "userId": 1,
     *                 "favoritesTitle": "考研资料",
     *                 "favoritesDescribe": null,
     *                 "isLimit": false,
     *                 "contentNumber": 0,
     *                 "followerNumber": 0,
     *                 "mark": "",
     *                 "createTime": "2021-11-09 20:55:57.0",
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
    public CommonResult selectListFavorites(@RequestParam int userId) throws Exception{
        log.info("selectListFavorites_userId==>"+userId);
        //转化为实体类
        return favoritesService.selectFavoritesByUserId(userId);
    }
}
