package cn.edu.guet.exchange.entities;

import java.util.Date;
import java.util.List;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/4 15:47
 * @Version:    1.0
 */

/**
 * 这是问题表，用来记录关于问题的各维度属性
 */
public class Problem {
    /**
     * 问题id
     */
    private Integer problemId;

    /**
     * 提问题的用户id
     */
    private Integer userId;

    /**
     * 问题描述，带问号
     */
    private String problemDescribe;

    /**
     * 输入问题背景、条件等详细信息（选填）
     */
    private String problemDetails;

    /**
     * 问题被浏览的次数
     */
    private Integer browseNumber;

    /**
     * 问题的关注人数
     */
    private Integer followerNumber;

    /**
     * 认为是好问题的人数
     */
    private Integer goodQuestionNumber;

    /**
     * 问题的评论个数
     */
    private Integer commentNumber;

    /**
     * 问题的回答个数
     */
    private Integer answerNumber;

    /**
     * 问题发布者是否匿名，0代表不生效，1代表生效
     */
    private Boolean isAnonymity;

    /**
     * 备注
     */
    private String mark;

    /**
     * 问题的被发布时间
     */
    private String createTime;

    /**
     * 问题被修改的最后一次时间
     */
    private String updateTime;

    /**
     * 逻辑删除，0不生效，1生效
     */
    private Boolean isDelete;

    /**
     * 收起时的缩略内容
     */
    private String abbreviatedContent;

    private List<OneTagId> tagList;

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

    public String getProblemDescribe() {
        return problemDescribe;
    }

    public void setProblemDescribe(String problemDescribe) {
        this.problemDescribe = problemDescribe;
    }

    public String getProblemDetails() {
        return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
        this.problemDetails = problemDetails;
    }

    public Integer getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }

    public Integer getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(Integer followerNumber) {
        this.followerNumber = followerNumber;
    }

    public Integer getGoodQuestionNumber() {
        return goodQuestionNumber;
    }

    public void setGoodQuestionNumber(Integer goodQuestionNumber) {
        this.goodQuestionNumber = goodQuestionNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public Boolean getIsAnonymity() {
        return isAnonymity;
    }

    public void setIsAnonymity(Boolean isAnonymity) {
        this.isAnonymity = isAnonymity;
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

    public String getAbbreviatedContent() {
        return abbreviatedContent;
    }

    public void setAbbreviatedContent(String abbreviatedContent) {
        this.abbreviatedContent = abbreviatedContent;
    }

    public List<OneTagId> getTagList() {
        return tagList;
    }

    public void setTagList(List<OneTagId> tagList) {
        this.tagList = tagList;
    }
}