package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: cyan
 * @Description: 上传
 * @Date: 2021/11/4 16:15
 * @Version: 1.0
 */
public interface UploadService {
    /**
     * 上传图片
     * @param request
     * @return url
     * @throws Exception
     */
    void uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
