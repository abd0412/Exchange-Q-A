package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.ProblemInvitation;
import com.netflix.ribbon.proxy.annotation.Var;

/**
 * @Author: cyan
 * @Description: 邀请回答
 * @Date: 2021/11/9 13:57
 * @Version: 1.0
 */
public interface ProblemInvitationService {
    /**
     * 添加邀请关系
     * @param record
     * @return
     */
    CommonResult insertSelective(ProblemInvitation record);

    /**
     * 查询用户对该问题的所有邀请信息
     * @param inviterId
     * @param problemId
     * @return
     */
    CommonResult selectAllInviteInfo(int inviterId, int problemId);
}
