package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.ProblemInvitation;
import cn.edu.guet.exchange.entities.ProblemInvitationList;
import cn.edu.guet.exchange.mapper.ProblemInvitationMapper;
import cn.edu.guet.exchange.service.ProblemInvitationService;
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
 * @Description: 邀请回答
 * @Date: 2021/11/9 13:58
 * @Version: 1.0
 */
@Service
@Slf4j
public class ProblemInvitationServiceImpl implements ProblemInvitationService {
    @Resource
    private ProblemInvitationMapper problemInvitationMapper;

    @Override
    public CommonResult insertSelective(ProblemInvitation record) {
        try {
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setUpdateTime(createTime);
            problemInvitationMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("添加邀请出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    @Override
    public CommonResult selectAllInviteInfo(int inviterId, int problemId) {
        ProblemInvitationList returnProblemInvitationList = new ProblemInvitationList();
        try {
            List<ProblemInvitation> problemInvitationList = problemInvitationMapper.selectInviteByInviterId(inviterId, problemId);
            returnProblemInvitationList.setProblemInvitationList(problemInvitationList);
        } catch (Exception e) {
            log.error("查询邀请出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", returnProblemInvitationList);
    }
}
