package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: cyan
 * @Description: 上传
 * @Date: 2021/11/4 16:19
 * @Version: 1.0
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Override
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile;
        String url;
        multipartFile = req.getFile("signImgFile");
        String realPath = uploadFolder;
        System.out.println("realPath==>" + realPath);
        try {
            //创建存放的目录
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //图片的名字
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");;
            String imageName = uuid + ".jpg";
            File file = new File(realPath, imageName);
            multipartFile.transferTo(file);
            url = "http://10.12.0.158:8383/imagesUpload/" + imageName;
            System.out.println("url==>" + url);
            response.setHeader("content-type", "text/html;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin","*");
            response.setHeader("Access-Control-Allow-Methods","POST");
            response.setHeader("Access-Control-Max-Age","1000");
            response.setHeader("url", url);
            response.getWriter().write(url);
        } catch (Exception e) {
            log.error("存放图片出现异常", e);
            //return new CommonResult(2001, "数据库执行有异常", null);
        }
       // return new CommonResult(200, "添加成功", url);
    }
}
