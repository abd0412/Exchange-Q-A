package cn.edu.guet.exchange.entities;

import java.util.List;

/**
 * @Author: cyan
 * @Description: 评论列表
 * @Date: 2021/11/6 15:24
 * @Version: 1.0
 */
public class CommentList {
    private List<Comment> commentList;

    private Integer totalPages;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
