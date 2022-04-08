package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Problem;

/**
 * @Author: cyan
 * @Description: 问题
 * @Date: 2021/11/4 14:45
 * @Version: 1.0
 */
public interface ProblemService {
    /**
     * 添加问题信息
     * @param record
     * @return
     */
    CommonResult insert(Problem record);

    /**
     * 根据分类查询问题
     * @param category
     * @param pageNumber
     * @param pageLength
     * @param userId
     * @return
     */
    CommonResult selectProblemByCategory(int category, int pageNumber, int pageLength, Integer userId);

    /**
     * 根据问题id查询问题信息
     * @param problemId
     * @return
     */
    CommonResult selectOneProblemInfo(Integer problemId);

}
