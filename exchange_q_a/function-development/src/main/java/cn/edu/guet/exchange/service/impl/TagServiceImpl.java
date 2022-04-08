package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Tag;
import cn.edu.guet.exchange.entities.User;
import cn.edu.guet.exchange.mapper.TagMapper;
import cn.edu.guet.exchange.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: cyan
 * @Description: 标签
 * @Date: 2021/11/6 22:08
 * @Version: 1.0
 */
@Service
@Slf4j
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public CommonResult selectByPrimaryKey(Integer tagId) {
        Tag tag;
        try{
            tag = tagMapper.selectByPrimaryKey(tagId);
        } catch(Exception e) {
            log.error("查询标签出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", tag);
    }
}
