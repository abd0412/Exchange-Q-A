package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Problem;
import cn.edu.guet.exchange.entities.ProblemInvitation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/9 13:41
 * @Version:    1.0
 */
@Mapper
public interface ProblemInvitationMapper {
    int deleteByPrimaryKey(Integer questionsInviteesId);

    int insert(ProblemInvitation record);

    int insertSelective(ProblemInvitation record);

    ProblemInvitation selectByPrimaryKey(Integer questionsInviteesId);

    int updateByPrimaryKeySelective(ProblemInvitation record);

    int updateByPrimaryKey(ProblemInvitation record);

    /**
     * 查询用户对该问题的所有邀请信息
     * @param inviterId
     * @param problemId
     * @return
     */
    List<ProblemInvitation> selectInviteByInviterId(@Param("inviterId") Integer inviterId, @Param("problemId") Integer problemId);

    /**
     * 查询用户被邀请回答信息
     *
     * @param lineNumber
     * @param pageLength
     * @param userId
     * @return
     */
    List<ProblemInvitation> selectInviteProblem(@Param("lineNumber") Integer lineNumber, @Param("pageLength") Integer pageLength, @Param("userId") Integer userId);


}