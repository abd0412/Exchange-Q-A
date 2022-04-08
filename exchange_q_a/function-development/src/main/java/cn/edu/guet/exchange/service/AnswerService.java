package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.Answer;
import cn.edu.guet.exchange.entities.Article;
import cn.edu.guet.exchange.entities.CommonResult;

import java.util.List;

/**
 * @Author: cyan
 * @Description: 回答
 * @Date: 2021/11/5 13:22
 * @Version: 1.0
 */
public interface AnswerService {
    /**
     * 添加回答
     * @param record
     * @return
     */
    CommonResult insert(Answer record);

    /**
     * 根据问题号查找所有答案
     * @param problemId
     * @return
     */
    CommonResult selectAnswerByProblemId(Integer problemId, Integer pageNumber, Integer pageLength);
}
