package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Relation;

/**
 * @Author: cyan
 * @Description: 用户与对象的关系管理
 * @Date: 2021/11/8 15:16
 * @Version: 1.0
 */
public interface RelationService {
    /**
     * 添加关系
     * @param record
     * @return
     */
    CommonResult insertSelective(Relation record);

    /**
     * 查询用户对一个对象的所有操作
     * @param userId
     * @param moduleCode
     * @param moduleId
     * @return
     */
    CommonResult selectObjectRelation(int userId, Integer moduleCode, Integer moduleId);

    /**
     * 对取消的操作做真删除
     * @param relationId
     * @return
     */
    CommonResult deleteByPrimaryKey(int relationId);
}
