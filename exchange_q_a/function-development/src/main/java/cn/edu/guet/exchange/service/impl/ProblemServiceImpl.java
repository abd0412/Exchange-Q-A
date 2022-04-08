package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.*;
import cn.edu.guet.exchange.mapper.ProblemInvitationMapper;
import cn.edu.guet.exchange.mapper.ProblemMapper;
import cn.edu.guet.exchange.mapper.TagOwnerMapper;
import cn.edu.guet.exchange.service.ProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: cyan
 * @Description: 问题
 * @Date: 2021/11/4 14:51
 * @Version: 1.0
 */
@Service
@Slf4j
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private ProblemMapper problemMapper;
    @Resource
    private TagOwnerMapper tagOwnerMapper;
    @Resource
    private ProblemInvitationMapper problemInvitationMapper;

    @Override
    public CommonResult insert(Problem record) {
        try {
            if(record.getTagList() == null||record.getTagList().size() == 0){
                return new CommonResult(1201, "至少有一个标签", record);
            }
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            problemMapper.insertSelective(record);
            //生成标签关系
            List<OneTagId> tagList = record.getTagList();
            for (OneTagId oneTagId : tagList) {
                TagOwner tagOwner = new TagOwner();
                tagOwner.setTagId(oneTagId.getTagId());
                tagOwner.setModuleId(record.getProblemId());
                tagOwner.setModuleCode(1);
                tagOwner.setUpdateTime(createTime);
                tagOwnerMapper.insert(tagOwner);
            }
        } catch(Exception e) {
            log.error("添加问题出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    @Override
    public CommonResult selectProblemByCategory(int category, int pageNumber, int pageLength, Integer userId) {
        ProblemList returnProblemList = new ProblemList();
        ProblemInvitationList returnProblemInvitationList = new ProblemInvitationList();
        try {
            //当类别为1时，为人气问题，查询规则为：问题的关注人数+认为是好问题的人数+问题的评论个数+问题的回答个数的总和从高到低排序
            if (1 == category){
                int lineNumber = (pageNumber-1)*pageLength;
                List<Problem> popularProblemList = problemMapper.selectPopularProblem(lineNumber, pageLength);
                returnProblemList.setProblemList(popularProblemList);
            }else if (2 == category){
                //当类别为2时，为最新问题，查询规则为：发布时间
                int lineNumber = (pageNumber-1)*pageLength;
                List<Problem> latestProblemList = problemMapper.selectLatestProblem(lineNumber, pageLength);
                returnProblemList.setProblemList(latestProblemList);

            }else if (3 == category){
                //当类别为3时，为邀请回答的问题，根据用户id查询
                int lineNumber = (pageNumber-1)*pageLength;
                List<ProblemInvitation> problemInvitationList = problemInvitationMapper.selectInviteProblem(lineNumber, pageLength, userId);
                returnProblemInvitationList.setProblemInvitationList(problemInvitationList);
                return new CommonResult(200, "查询成功：页码"+ pageNumber + "包含的邀请回答信息", returnProblemInvitationList);
            }

        } catch (Exception e) {
            log.error("查询分类为" + category + "的问题时出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功：页码"+ pageNumber + "包含的所有问题信息", returnProblemList);
    }

    @Override
    public CommonResult selectOneProblemInfo(Integer problemId) {
        Problem problem;
        try {
            //moduleCode分类 1：问题；2：文章；3: 回答；
            int moduleCode = 1;
            problem = problemMapper.selectByPrimaryKey(problemId);
            //查询文章的标签
            List<Integer> tagOwnerList = tagOwnerMapper.selectTagByProblemId(problemId, moduleCode);
            List<OneTagId> tagList = new ArrayList<>();
            for (Integer integer : tagOwnerList) {
                OneTagId oneTagId = new OneTagId();
                oneTagId.setTagId(integer);
                tagList.add(oneTagId);
            }
            problem.setTagList(tagList);
        } catch(Exception e) {
            log.error("查询问题出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", problem);
    }
}
