package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/6 22:21
 * @Version:    1.0
 */

/**
 * 这是标签表，用来记录关于标签的各维度属性
 */
public class Tag {
    /**
     * 标签id
     */
    private Integer tagId;

    /**
     * 标签所属类别id
     */
    private Integer categoryId;

    /**
     * 标签内容
     */
    private String tagContent;

    /**
     * 备注
     */
    private String mark;

    /**
     * 注释
     */
    private String note;

    /**
     * 标签创建的时间
     */
    private Date createTime;

    /**
     * 标签修改的最后一次时间
     */
    private Date updateTime;

    /**
     * 标签的逻辑删除，0不生效，1生效
     */
    private Boolean isDelete;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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