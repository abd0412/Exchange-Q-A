package cn.edu.guet.exchange.controller;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.UploadService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: cyan
 * @Description: 向服务器上上传图片，视频，文档等的接口
 * @Date: 2021/11/4 16:10
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/upload")
public class UploadController {
    @Resource
    private UploadService uploadService;
    /**
     * @api {post} /upload/image 上传图片
     * @apiVersion 0.0.1
     * @apiDescription  上传图片
     * @apiGroup 上传-Upload
     *
     * @apiParam(入参) {File} signImgFile 图片key
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-上传成功；2001-上传失败；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} data 图片url
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "添加成功",
     *     "data": "http://120.79.31.81/imagesUpload/756c7196-a944-4e25-bc82-75eccc99fbf8.jpg"
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": "2001",
     * 	   "Message": "上传失败"
     * }
     */
    @PostMapping(value = "/image")
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        uploadService.uploadImage(request, response);
    }
}
