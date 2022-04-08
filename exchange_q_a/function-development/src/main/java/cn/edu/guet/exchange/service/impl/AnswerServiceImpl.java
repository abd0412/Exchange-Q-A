package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.*;
import cn.edu.guet.exchange.mapper.AnswerMapper;
import cn.edu.guet.exchange.mapper.ProblemMapper;
import cn.edu.guet.exchange.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author: cyan
 * @Description: 回答
 * @Date: 2021/11/5 13:30
 * @Version: 1.0
 */
@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;
    @Resource
    private ProblemMapper problemMapper;

    @Override
    public CommonResult insert(Answer record) {
        try {
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            answerMapper.insertSelective(record);
            //更新问题的回答数量
            int problemId = record.getProblemId();
            Problem problem = problemMapper.selectByPrimaryKey(problemId);
            //回答数量加1
            int answerNumber = problem.getAnswerNumber();
            answerNumber += 1;
            //更新到数据库
            Problem newAnswerNumberProblem = new Problem();
            newAnswerNumberProblem.setProblemId(problemId);
            newAnswerNumberProblem.setAnswerNumber(answerNumber);
            problemMapper.updateByPrimaryKeySelective(newAnswerNumberProblem);
        } catch (Exception e) {
            log.error("添加回答出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    @Override
    public CommonResult selectAnswerByProblemId(Integer problemId, Integer pageNumber, Integer pageLength) {
        AnswerList returnAnswerList = new AnswerList();
        try {
            int lineNumber = (pageNumber-1)*pageLength;
            List<Answer> answerList = answerMapper.selectAnswerByProblemId(problemId, lineNumber, pageLength);
            returnAnswerList.setAnswerList(answerList);
        } catch (Exception e) {
            log.error("查询问题id为"+problemId+"时出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功：页码"+ pageNumber + "包含的所有回答信息", returnAnswerList);
    }
}
