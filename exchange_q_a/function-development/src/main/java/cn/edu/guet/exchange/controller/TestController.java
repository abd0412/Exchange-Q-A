package cn.edu.guet.exchange.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.WangEditorVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author: cyan
 * @Description: 测试
 * @Date: 2021/11/5 11:51
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {
    @PostMapping(value = "/image")
    public CommonResult uploadImage(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile;
        String returnContext = "测试测试测试";
        System.out.println("测试测试测试");
        return new CommonResult(200, "调用成功", returnContext);
    }

    @PostMapping(value = "/image1")
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile;
        String returnContext = "测试测试测试";
        System.out.println("测试测试测试");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Max-Age","1000");
        response.setHeader("url", returnContext);
        response.getWriter().write(returnContext);
    }

    @GetMapping(value = "/image2")
    public String uploadImage() throws Exception {
        String returnContext = "测试测试测试";
        System.out.println("测试测试测试");
        return returnContext;
    }




    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @RequestMapping(value = "/file/tinymce", method = RequestMethod.POST)
    public CommonResult tinymceFileUpload(MultipartFile multipartFile) throws IOException {
        String realPath = uploadFolder;
        //创建存放的目录
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        //图片的名字
        String uuid = java.util.UUID.randomUUID().toString();
        String imageName = uuid + ".jpg";
        File file = new File(realPath, imageName);
        multipartFile.transferTo(file);
        String url = "http://10.12.0.158:8383/imagesUpload/" + imageName;
        // TODO 文件上传操作
        return new CommonResult(200, "上传成功", url);
    }

    @PostMapping("/wangUpload")
    @ResponseBody
    public WangEditorVO wangUpload(MultipartFile[] file) throws IOException {
        //当file为空时
        if (file == null || file.length == 0) {
            return WangEditorVO.error(1, "无图片信息");
        }

        //存入数据库的文件地址集合
        List<String> pathList = new ArrayList<>();
        for (MultipartFile multipartFile : file) {
            //获取文件名
            String name = UUID.randomUUID().toString();
            String imageName = name + ".jpg";
            //拼接完整的 存放图片地址，即：D:\\IO\\shop\\shopImage\\文件名.后缀名
            File path = new File(uploadFolder, imageName);
            //将图片存放到path路径下
            multipartFile.transferTo(path);
            //拼接完整的 访问图片地址，即：http://localhost:8888/文件名.后缀名
            pathList.add("http://10.12.0.158:8383/imagesUpload/" + imageName);
        }

        return WangEditorVO.success(pathList);
    }
}
