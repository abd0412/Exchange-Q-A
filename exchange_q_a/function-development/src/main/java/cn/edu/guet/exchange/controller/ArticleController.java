package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.Article;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Problem;
import cn.edu.guet.exchange.service.ArticleService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 文章模块
 * @Date: 2021/11/4 20:59
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    /**
     * @api {post} /article/add 发布文章
     * @apiVersion 0.0.1
     * @apiDescription  用户发布文章的接口
     * @apiGroup 文章-Article
     * @apiParam(入参) {int} userId 文章的用户id（系统生成唯一，在用户登录时返回），必填
     * @apiParam(入参) {String} articleTitle 文章标题，必填
     * @apiParam(入参) {text} articleContent 文章内容，必填
     * @apiParam(入参) {text} abbreviatedContent 收起的缩略内容
     * @apiParam(入参) {String} articleCoverUrl 文章封面（调用图片上传接口），选填
     * @apiParam(入参) {int} declare 创作声明，暂分类为：0：无声明（默认）; 1：虚假创作; 2: 包含理财内容; 3: 包含剧透；4：包含医疗建议;
     * @apiParam(入参) {array} tagList 标签列表，至少带一个，文章带的话题是个标签，所属分类是话题
     * @apiParam(入参) {int} tagId 标签id，值列表，需数据库中拥有。
     * @apiParamExample {json} 入参样例：
     * {
     *     "userId": 1,
     *     "articleTitle": "100个英语词组",
     *     "articleContent": "<p>xxx</p >",
     *     "abbreviatedContent": "xxx",
     *     "articleCoverUrl": "http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg",
     *     "declare": 1,
     *     "tagList": [
     *             {
     *                 "tagId": 1
     *             },
     *             {
     *                 "tagId": 2
     *             }
     *         ]
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
     *         "articleId": 2,
     *         "userId": 1,
     *         "articleTitle": "100个英语词组",
     *         "articleContent": "<p>xxx</p >",
     *         "linkName": null,
     *         "linkUrl": null,
     *         "declare": 1,
     *         "introduce": null,
     *         "isPush": null,
     *         "isAllowed": null,
     *         "isRestriction": null,
     *         "restrictionType": null,
     *         "agreeNumber": null,
     *         "disagreeNumber": null,
     *         "commentNumber": null,
     *         "mark": null,
     *         "createTime": "2021-11-04 23:16:05",
     *         "updateTime": null,
     *         "isDelete": null,
     *         "articleCoverUrl": "http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg",
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
    public CommonResult addArticle(@RequestBody String json) throws Exception{
        log.info("addArticle==>"+json);
        //转化为实体类
        Article article = JSON.parseObject(json, Article.class);
        return articleService.insert(article);
    }

    /**
     * @api {get} /article/select?articleId=2 查询某文章
     * @apiVersion 0.0.1
     * @apiDescription  根据文章id获取该文章的所有信息
     * @apiGroup 文章-Article
     * @apiParam(入参) {int} articleId 文章id，必填
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
     *         "articleId": 2,
     *         "userId": 1,
     *         "articleTitle": "100个英语词组",
     *         "articleContent": "<p>xxx</p >",
     *         "linkName": null,
     *         "linkUrl": null,
     *         "declare": 1,
     *         "introduce": null,
     *         "isPush": true,
     *         "isAllowed": true,
     *         "isRestriction": false,
     *         "restrictionType": null,
     *         "agreeNumber": null,
     *         "disagreeNumber": null,
     *         "commentNumber": null,
     *         "mark": null,
     *         "createTime": "2021-11-04 23:16:05.0",
     *         "updateTime": null,
     *         "isDelete": false,
     *         "articleCoverUrl": "http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg",
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
    public CommonResult selectOneArticle(@RequestParam int articleId) throws Exception{
        log.info("selectOneArticle_articleId==>"+articleId);
        return articleService.selectOneArticleInfo(articleId);
    }

    /**
     * @api {get} /article/selectList?pageNumber=2&pageLength=10 查询所有文章
     * @apiVersion 0.0.1
     * @apiDescription  分页查询所有文章
     * @apiGroup 文章-Article
     * @apiParam(入参) {int} pageNumber 页码，必填
     * @apiParam(入参) {int} pageLength 页面长度，必填，唯一限定某一值
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {object} articleList 文章列表
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功：页码2包含的所有文章信息",
     *     "data": {
     *         "articleList": [
     *             {
     *                 "articleId": 3,
     *                 "userId": 1,
     *                 "articleTitle": "100个英语词组",
     *                 "articleContent": "<p>xxx</p >",
     *                 "linkName": null,
     *                 "linkUrl": null,
     *                 "declare": 1,
     *                 "introduce": null,
     *                 "isPush": true,
     *                 "isAllowed": true,
     *                 "isRestriction": false,
     *                 "restrictionType": null,
     *                 "agreeNumber": 0,
     *                 "disagreeNumber": 0,
     *                 "commentNumber": 0,
     *                 "mark": null,
     *                 "createTime": "2021-11-11 19:40:39.0",
     *                 "updateTime": null,
     *                 "isDelete": false,
     *                 "articleCoverUrl": "http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg",
     *                 "abbreviatedContent": "xxx",
     *                 "tagList": null
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
    public CommonResult selectListArticle(@RequestParam int pageNumber, int pageLength) throws Exception {
        log.info("selectListArticle_pageNumber==>"+pageNumber);
        log.info("selectListArticle_pageLength==>"+pageLength);
        return articleService.selectAllArticle(pageNumber, pageLength);
    }

}
