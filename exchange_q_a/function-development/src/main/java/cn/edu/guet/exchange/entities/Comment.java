package cn.edu.guet.exchange.entities;

import java.util.Date;
import java.util.List;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/6 14:41
 * @Version:    1.0
 */

/**
 * 这是评论表，用来记录关于评论的各维度属性
 */
public class Comment {
    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 给与评论的用户id
     */
    private Integer userId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论针对的对象类型，1：problem；2：answer；3：comment;  4：article; 5: idea
     */
    private Integer moduleCode;

    /**
     * 评论所针对的对象的id：problem_id、answer_id、comment_id、article_id、idea_id
     */
    private Integer moduleId;

    /**
     * 评论的点赞人数
     */
    private Integer approvalNumber;

    /**
     * 备注
     */
    private String mark;

    /**
     * 评论的创建时间
     */
    private String createTime;

    /**
     * 评论的最后一次修改时间（但是用户不能修改评论只能删除评论，即该字段记录逻辑删除生效的时间）
     */
    private String updateTime;

    /**
     * 逻辑删除，0不生效，1生效
     */
    private Boolean isDelete;

    /**
     * 查询时的子评论
     */
    private List<Response> subCommentList;

    /**
     * 评论的源头类型：1：problem；2：answer；3：article；4：idea；用于评论计数。
     */
    private Integer rootModuleCode;

    /**
     * 评论的源头id，用于评论计数
     */
    private Integer rootModuleId;

    /**
     * 根评论id
     */
    private Integer rootCommentId;

    /**
     * 回复数量
     */
    private Integer responseNumber;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(Integer moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(Integer approvalNumber) {
        this.approvalNumber = approvalNumber;
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

    public List<Response> getSubCommentList() {
        return subCommentList;
    }

    public void setSubCommentList(List<Response> subCommentList) {
        this.subCommentList = subCommentList;
    }

    public Integer getRootModuleCode() {
        return rootModuleCode;
    }

    public void setRootModuleCode(Integer rootModuleCode) {
        this.rootModuleCode = rootModuleCode;
    }

    public Integer getRootModuleId() {
        return rootModuleId;
    }

    public void setRootModuleId(Integer rootModuleId) {
        this.rootModuleId = rootModuleId;
    }

    public Integer getRootCommentId() {
        return rootCommentId;
    }

    public void setRootCommentId(Integer rootCommentId) {
        this.rootCommentId = rootCommentId;
    }

    public Integer getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(Integer responseNumber) {
        this.responseNumber = responseNumber;
    }
}