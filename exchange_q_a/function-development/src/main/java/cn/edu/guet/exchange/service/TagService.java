package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Tag;

/**
 * @Author: cyan
 * @Description: 标签
 * @Date: 2021/11/6 22:07
 * @Version: 1.0
 */
public interface TagService {
    /**
     * 根据标签id查询标签信息
     * @param tagId
     * @return
     */
    CommonResult selectByPrimaryKey(Integer tagId);

}
