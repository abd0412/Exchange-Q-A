package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.Collect;
import cn.edu.guet.exchange.entities.CommonResult;

/**
 * @Author: cyan
 * @Description: 收藏
 * @Date: 2021/11/9 22:09
 * @Version: 1.0
 */
public interface CollectService {
    /**
     * 添加收藏关系
     * @param record
     * @return
     */
    CommonResult insertSelective(Collect record);

    /**
     * 查询用户对某对象的收藏情况
     * @param userId
     * @param moduleCode
     * @param moduleId
     * @return
     */
    CommonResult selectAllCollect(int userId, int moduleCode, int moduleId);

    /**
     * 删除收藏关系
     * @param collectId
     * @return
     */
    CommonResult deleteByPrimaryKey(int collectId);
}
