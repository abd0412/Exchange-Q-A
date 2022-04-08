package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.*;
import cn.edu.guet.exchange.mapper.ArticleMapper;
import cn.edu.guet.exchange.mapper.TagOwnerMapper;
import cn.edu.guet.exchange.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: cyan
 * @Description: 文章
 * @Date: 2021/11/4 22:08
 * @Version: 1.0
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagOwnerMapper tagOwnerMapper;

    @Override
    public CommonResult insert(Article record) {
        try {
            if(record.getTagList() == null||record.getTagList().size() == 0){
                return new CommonResult(1201, "至少有一个标签", record);
            }
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            articleMapper.insertSelective(record);
            List<OneTagId> tagList = record.getTagList();
            for (OneTagId oneTagId : tagList) {
                TagOwner tagOwner = new TagOwner();
                tagOwner.setTagId(oneTagId.getTagId());
                tagOwner.setModuleId(record.getArticleId());
                tagOwner.setModuleCode(2);
                tagOwner.setUpdateTime(createTime);
                tagOwnerMapper.insert(tagOwner);
            }

        } catch (Exception e) {
            log.error("添加文章出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    @Override
    public CommonResult selectOneArticleInfo(Integer articleId) {
        Article article ;
        try {
            //moduleCode分类 1：问题；2：文章；3: 回答；
            int moduleCode = 2;
            article = articleMapper.selectByPrimaryKey(articleId);
            //查询文章的标签
            List<Integer> tagOwnerList = tagOwnerMapper.selectTagByArticleId(articleId, moduleCode);
            List<OneTagId> tagList = new ArrayList<>();
            for (Integer integer : tagOwnerList) {
                OneTagId oneTagId = new OneTagId();
                oneTagId.setTagId(integer);
                tagList.add(oneTagId);
            }
            article.setTagList(tagList);
        } catch(Exception e) {
            log.error("查询文章出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", article);
    }

    @Override
    public CommonResult selectAllArticle(int pageNumber, int pageLength) {
        ArticleList returnArticleList = new ArticleList();
        try {
            int lineNumber = (pageNumber-1)*pageLength;
            List<Article> articleList = articleMapper.selectAllAnswer(lineNumber, pageLength);
            returnArticleList.setArticleList(articleList);
        } catch (Exception e) {
            log.error("查询所有文章时出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功：页码"+ pageNumber + "包含的所有文章信息", returnArticleList);
    }
}
