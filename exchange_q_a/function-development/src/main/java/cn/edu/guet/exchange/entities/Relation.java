package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/8 22:19
 * @Version:    1.0
 */

/**
 * 这是关系表，用来记录关于用户->用户，用户->问题，用户->回答，用户->文章，用户->评论，用户->收藏夹的各维度关系
 */
public class Relation {
    /**
     * 关系表的主键
     */
    private Integer relationId;

    /**
     * 登录用户的id
     */
    private Integer userId;

    /**
     * 登录用户与谁有关系：1：problem；2：answer；3：comment；4：article； 5：idea；6：user；7：favorites
     */
    private Integer moduleCode;

    /**
     * 关系对象的类型id：problem_id/answer_id/comment_id/article_id/idea_id/user_id/favorites_id
     */
    private Integer moduleId;

    /**
     * 用户与对象的关系类型:
     * 问题：1：关注问题；2：好问题；
     * 回答：1：赞同；2：不赞同；3：喜欢；
     * 评论：1：赞；2：踩；
     * 文章：1：赞同；2：不赞同；3：喜欢；4：已转载；
     * 想法：1：鼓掌；
     * 其他用户：1：关注；
     * 其他用户的收藏夹：1：关注
     */
    private Integer relationType;

    /**
     * 备注
     */
    private String mark;

    /**
     * 关系创建的时间
     */
    private String createTime;

    /**
     * 若做假删除：关系删除的时间，即取消操作发生的时间
     */
    private String updateTime;

    /**
     * 逻辑删除，0不生效，1生效
     */
    private Boolean isDelete;

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
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
}