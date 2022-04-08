package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 标签
 * @Date: 2021/11/6 20:02
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/tag")
public class TagController {
    @Resource
    private TagService tagService;
    /**
     * @api {get} /tag/select?tagId=1 查询标签信息
     * @apiVersion 0.0.1
     * @apiDescription  根据标签id获取该标签的所有信息
     * @apiGroup 标签-Tag
     * @apiParam(入参) {int} tagId 标签id，必填
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
     *         "tagId": 1,
     *         "categoryId": 1,
     *         "tagContent": "战机",
     *         "mark": "测试使用",
     *         "note": null,
     *         "createTime": "2021-11-04T07:54:17.000+0000",
     *         "updateTime": null,
     *         "isDelete": false
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
    public CommonResult selectTag(@RequestParam int tagId) throws Exception{
        log.info("selectTag_tagId==>"+tagId);
        return tagService.selectByPrimaryKey(tagId);
    }

}
