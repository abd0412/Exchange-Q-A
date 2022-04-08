package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/5 15:33
 * @Version:    1.0
 */

/**
 * 这是回答表，用来记录关于回答的各维度属性
 */
public class Answer {
    /**
     * 回答id
     */
    private Integer answerId;

    /**
     * 问题id
     */
    private Integer problemId;

    /**
     * 回答的用户id
     */
    private Integer userId;

    /**
     * 回答内容
     */
    private String answerContent;

    /**
     * 创作声明，暂分类为：0：无声明（默认）; 1：虚假创作; 2: 包含理财内容; 3: 包含剧透；4：包含医疗建议;
     */
    private Integer declare;

    /**
     * 是否匿名，0：不匿名（默认）；1：匿名
     */
    private Boolean isAnonymity;

    /**
     * 一句话介绍
     */
    private String introduce;

    /**
     * 是否推送给关注者，0：不推；1：推送（默认）
     */
    private Boolean isPush;

    /**
     * 是否允许转载，0：不允许; 1: 允许（默认）
     */
    private Boolean isAllowed;

    /**
     * 是否限制评论，0：不限制（系统默认）; 1: 限制
     */
    private Boolean isRestriction;

    /**
     * 限制类型，若限制开启则：1：允许我关注的人评论；2：答主筛选显示；3：禁止评论
     */
    private Integer restrictionType;

    /**
     * 这个回答的赞同人数
     */
    private Integer agreeNumber;

    /**
     * 这个回答的不赞同人数
     */
    private Integer disagreeNumber;

    /**
     * 这个回答的评论人数
     */
    private Integer commentNumber;

    /**
     * 备注
     */
    private String mark;

    /**
     * 回答创建的时间
     */
    private String createTime;

    /**
     * 回答的最后一次修改时间
     */
    private String updateTime;

    /**
     * 逻辑删除，0不生效，1生效
     */
    private Boolean isDelete;

    /**
     * 回答的收起的缩略内容
     */
    private String answerAbbreviatedContent;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getDeclare() {
        return declare;
    }

    public void setDeclare(Integer declare) {
        this.declare = declare;
    }

    public Boolean getIsAnonymity() {
        return isAnonymity;
    }

    public void setIsAnonymity(Boolean isAnonymity) {
        this.isAnonymity = isAnonymity;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Boolean getIsPush() {
        return isPush;
    }

    public void setIsPush(Boolean isPush) {
        this.isPush = isPush;
    }

    public Boolean getIsAllowed() {
        return isAllowed;
    }

    public void setIsAllowed(Boolean isAllowed) {
        this.isAllowed = isAllowed;
    }

    public Boolean getIsRestriction() {
        return isRestriction;
    }

    public void setIsRestriction(Boolean isRestriction) {
        this.isRestriction = isRestriction;
    }

    public Integer getRestrictionType() {
        return restrictionType;
    }

    public void setRestrictionType(Integer restrictionType) {
        this.restrictionType = restrictionType;
    }

    public Integer getAgreeNumber() {
        return agreeNumber;
    }

    public void setAgreeNumber(Integer agreeNumber) {
        this.agreeNumber = agreeNumber;
    }

    public Integer getDisagreeNumber() {
        return disagreeNumber;
    }

    public void setDisagreeNumber(Integer disagreeNumber) {
        this.disagreeNumber = disagreeNumber;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getAnswerAbbreviatedContent() {
        return answerAbbreviatedContent;
    }

    public void setAnswerAbbreviatedContent(String answerAbbreviatedContent) {
        this.answerAbbreviatedContent = answerAbbreviatedContent;
    }
}