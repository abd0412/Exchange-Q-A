package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/6 23:01
 * @Version:    1.0
 */
/**
    * 这是想法表，用来记录关于想法的各维度属性
    */
public class Idea {
    /**
    * 回答id
    */
    private Integer ideaId;

    /**
    * 回答的用户id
    */
    private Integer userId;

    /**
    * 想法内容
    */
    private String ideaContent;

    /**
    * 评论限制，0不生效，1生效
    */
    private Boolean isRestriction;

    /**
    * 限制类型
    */
    private String restrictionType;

    /**
    * 这个想法的鼓掌人数
    */
    private Integer applauseNumber;

    /**
    * 这个想法的评论人数
    */
    private Integer commentNumber;

    /**
    * 备注
    */
    private String mark;

    /**
    * 第一次
    */
    private Date createTime;

    /**
    * 最后一次
    */
    private Date updateTime;

    /**
    * 逻辑删除，0不生效，1生效
    */
    private Boolean isDelete;

    public Integer getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Integer ideaId) {
        this.ideaId = ideaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdeaContent() {
        return ideaContent;
    }

    public void setIdeaContent(String ideaContent) {
        this.ideaContent = ideaContent;
    }

    public Boolean getIsRestriction() {
        return isRestriction;
    }

    public void setIsRestriction(Boolean isRestriction) {
        this.isRestriction = isRestriction;
    }

    public String getRestrictionType() {
        return restrictionType;
    }

    public void setRestrictionType(String restrictionType) {
        this.restrictionType = restrictionType;
    }

    public Integer getApplauseNumber() {
        return applauseNumber;
    }

    public void setApplauseNumber(Integer applauseNumber) {
        this.applauseNumber = applauseNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}