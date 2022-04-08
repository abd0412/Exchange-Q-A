package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/5 20:56
 * @Version: 1.0
 */
public class TagOwner {
    /**
     * 主键自增
     */
    private Integer tagOwnerId;

    /**
     * 标签id
     */
    private Integer tagId;

    /**
     * 标签拥有者id
     */
    private Integer moduleId;

    /**
     * 1：问题；2：文章；3: 回答；
     */
    private Integer moduleCode;

    /**
     * 关系创建/更新时间
     */
    private String updateTime;

    /**
     * 逻辑删除，0：不删除（默认）； 1：不删除
     */
    private Boolean isDelete;

    public Integer getTagOwnerId() {
        return tagOwnerId;
    }

    public void setTagOwnerId(Integer tagOwnerId) {
        this.tagOwnerId = tagOwnerId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(Integer moduleCode) {
        this.moduleCode = moduleCode;
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