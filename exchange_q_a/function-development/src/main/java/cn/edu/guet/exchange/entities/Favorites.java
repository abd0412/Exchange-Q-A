package cn.edu.guet.exchange.entities;

import java.util.Date;

/**
 * 这是收藏夹表，用来记录关于收藏夹的各维度属性
 * @author cyan
 * @Date:    2021/11/9 20:17
 * @Version:    1.0
 */
public class Favorites {
    /**
     * 收藏夹id
     */
    private Integer favoritesId;

    /**
     * 创建收藏夹的用户id
     */
    private Integer userId;

    /**
     * 收藏夹标题
     */
    private String favoritesTitle;

    /**
     * 收藏夹描述
     */
    private String favoritesDescribe;

    /**
     * 公开还是私密，0表示不生效即公开，1表示生效即私密
     */
    private Boolean isLimit;

    /**
     * 收藏内容的数量
     */
    private Integer contentNumber;

    /**
     * 关注者数量
     */
    private Integer followerNumber;

    /**
     * 备注
     */
    private String mark;

    /**
     * 收藏夹的创建时间
     */
    private String createTime;

    /**
     * 当收藏内容的数量改变时更新该时间
     */
    private String updateTime;

    /**
     * 逻辑删除，0不生效，1生效
     */
    private Boolean isDelete;

    public Integer getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(Integer favoritesId) {
        this.favoritesId = favoritesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFavoritesTitle() {
        return favoritesTitle;
    }

    public void setFavoritesTitle(String favoritesTitle) {
        this.favoritesTitle = favoritesTitle;
    }

    public String getFavoritesDescribe() {
        return favoritesDescribe;
    }

    public void setFavoritesDescribe(String favoritesDescribe) {
        this.favoritesDescribe = favoritesDescribe;
    }

    public Boolean getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(Boolean isLimit) {
        this.isLimit = isLimit;
    }

    public Integer getContentNumber() {
        return contentNumber;
    }

    public void setContentNumber(Integer contentNumber) {
        this.contentNumber = contentNumber;
    }

    public Integer getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(Integer followerNumber) {
        this.followerNumber = followerNumber;
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