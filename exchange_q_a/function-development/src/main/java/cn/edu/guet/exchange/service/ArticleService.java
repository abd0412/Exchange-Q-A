package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.Article;
import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Problem;

/**
 * @Author: cyan
 * @Description: 文章
 * @Date: 2021/11/4 21:58
 * @Version: 1.0
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param record
     * @return
     */
    CommonResult insert(Article record);

    /**
     * 根据文章id查询该文章的信息
     * @param articleId
     * @return
     */
    CommonResult selectOneArticleInfo(Integer articleId);

    /**
     * 分页查询所有文章
     * @param pageNumber
     * @param pageLength
     * @return
     */
    CommonResult selectAllArticle(int pageNumber, int pageLength);
}
