package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/9 13:41
 * @Version:    1.0
 */
/**
    * 问题与邀请者和被邀请者的关系表
    */
public class ProblemInvitation {
    /**
    * 问题与问题邀请回答者关系表的主键
    */
    private Integer questionsInviteesId;

    /**
    * 问题id
    */
    private Integer problemId;

    /**
    * 邀请者（对应user表中的user_id）
    */
    private Integer inviterId;

    /**
    * 被邀请者（对应user表中的user_id）
    */
    private Integer inviteeId;

    /**
    * 关系创建/更新时间
    */
    private String updateTime;

    /**
    * 逻辑删除，0：不删除（默认），1：删除
    */
    private Boolean isDelete;

    public Integer getQuestionsInviteesId() {
        return questionsInviteesId;
    }

    public void setQuestionsInviteesId(Integer questionsInviteesId) {
        this.questionsInviteesId = questionsInviteesId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public Integer getInviteeId() {
        return inviteeId;
    }

    public void setInviteeId(Integer inviteeId) {
        this.inviteeId = inviteeId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}