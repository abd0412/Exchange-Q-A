package cn.edu.guet.exchange.entities;

/**
 * @Author: cyan
 * @Description: 回复关系
 * @Date: 2021/11/16 22:30
 * @Version: 1.0
 */
public class Response {
    /**
     * 相关评论信息
     */
    private Comment comment;
    /**
     * 回复者id
     */
    private User replyUser;
    /**
     * 被回复者id
     */
    private User beRepliedUser;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(User replyUser) {
        this.replyUser = replyUser;
    }

    public User getBeRepliedUser() {
        return beRepliedUser;
    }

    public void setBeRepliedUser(User beRepliedUser) {
        this.beRepliedUser = beRepliedUser;
    }
}
