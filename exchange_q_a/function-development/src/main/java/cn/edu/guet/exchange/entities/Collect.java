package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/10 14:16
 * @Version:    1.0
 */
/**
    * 这是收藏内容表，用来记录关于收藏内容的各维度属性
    */
public class Collect {
    /**
    * 收藏关系主键
    */
    private Integer collectId;

    /**
    * 收藏用户id
    */
    private Integer userId;

    /**
    * 被收藏对象类型：1：回答；2：文章；3：想法；
    */
    private Integer moduleCode;

    /**
    * 被收藏对象id，对应于answer_id/article_id/idea_id
    */
    private Integer moduleId;

    /**
    * 收藏夹id
    */
    private Integer favoritesId;

    /**
    * 备注
    */
    private String mark;

    /**
    * 收藏时间
    */
    private String createTime;

    /**
    * 逻辑删除，0不生效，1生效
    */
    private Boolean isDelete;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
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

    public Integer getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(Integer favoritesId) {
        this.favoritesId = favoritesId;
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}