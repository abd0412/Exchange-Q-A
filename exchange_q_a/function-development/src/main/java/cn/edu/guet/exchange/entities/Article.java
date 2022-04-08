package cn.edu.guet.exchange.entities;

import java.util.Date;
import java.util.List;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/4 22:04
 * @Version:    1.0
 */
/**
    * 这是文章表，用来记录关于文章的各维度属性
    */
public class Article {
    /**
    * 文章id
    */
    private Integer articleId;

    /**
    * 文章的用户id
    */
    private Integer userId;

    /**
    * 文章标题
    */
    private String articleTitle;

    /**
    * 文章内容
    */
    private String articleContent;

    /**
    * 链接名
    */
    private String linkName;

    /**
    * 链接
    */
    private String linkUrl;

    /**
    * 0：无声明（默认）; 1：虚假创作; 2: 包含理财内容; 3: 包含剧透；4：包含医疗建议;
    */
    private Integer declare;

    /**
    * 一句话介绍
    */
    private String introduce;

    /**
    * 推送给关注者，0不生效，1生效
    */
    private Boolean isPush;

    /**
    * 允许转载，0不生效，1生效
    */
    private Boolean isAllowed;

    /**
    * 评论限制：0代表不生效，1代表生效
    */
    private Boolean isRestriction;

    /**
    * 限制类型
    */
    private String restrictionType;

    /**
    * 这个文章的赞同人数
    */
    private Integer agreeNumber;

    /**
    * 这个文章的不赞同人数
    */
    private Integer disagreeNumber;

    /**
    * 这个文章的评论人数
    */
    private Integer commentNumber;

    /**
    * 备注
    */
    private String mark;

    /**
    * 文章发布的时间
    */
    private String createTime;

    /**
    * 文章最后一次修改的时间
    */
    private String updateTime;

    /**
    * 逻辑删除，0不生效，1生效
    */
    private Boolean isDelete;

    /**
    * 文章封面
    */
    private String articleCoverUrl;

    /**
    * 收起的缩略内容
    */
    private String abbreviatedContent;

    /**
     * 用来接收标签列表
     */
    private List<OneTagId> tagList;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getDeclare() {
        return declare;
    }

    public void setDeclare(Integer declare) {
        this.declare = declare;
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

    public String getRestrictionType() {
        return restrictionType;
    }

    public void setRestrictionType(String restrictionType) {
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

    public String getArticleCoverUrl() {
        return articleCoverUrl;
    }

    public void setArticleCoverUrl(String articleCoverUrl) {
        this.articleCoverUrl = articleCoverUrl;
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