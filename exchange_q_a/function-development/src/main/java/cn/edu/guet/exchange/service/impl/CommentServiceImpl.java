package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.*;
import cn.edu.guet.exchange.mapper.*;
import cn.edu.guet.exchange.service.CommentService;
import com.netflix.ribbon.proxy.annotation.Var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: cyan
 * @Description: 评论
 * @Date: 2021/11/6 11:12
 * @Version: 1.0
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ProblemMapper problemMapper;
    @Resource
    private AnswerMapper answerMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private IdeaMapper ideaMapper;
    @Resource
    private UserMapper userMapper;

    //更新评论数量
    public void addOrDeleteComment(Comment record, String type) {
        try {
            int rootModuleCode = record.getRootModuleCode();
            int moduleCode = record.getModuleCode();
            //在被评论的对象上增加/减少评论数量，1：problem；2：answer；3：article；4：idea；
            int moduleId = record.getRootModuleId();
            if (rootModuleCode == 1) {
                //如果是评论问题，在问题表中找到值为moduleId的problem_id
                Problem problem = problemMapper.selectByPrimaryKey(moduleId);
                int commentNumber = problem.getCommentNumber();
                if("add".equals(type)){
                    //评论数量加1
                    commentNumber += 1;
                }else if ("delete".equals(type)){
                    //评论数量减1
                    commentNumber -= 1;
                }
                //更新到数据库
                Problem newCommentNumberProblem = new Problem();
                newCommentNumberProblem.setProblemId(moduleId);
                newCommentNumberProblem.setCommentNumber(commentNumber);
                problemMapper.updateByPrimaryKeySelective(newCommentNumberProblem);
            } else if (rootModuleCode == 2) {
                //如果是评论回答，在回答表中找到值为moduleId的answer_id
                Answer answer = answerMapper.selectByPrimaryKey(moduleId);
                int commentNumber = answer.getCommentNumber();
                if("add".equals(type)){
                    //评论数量加1
                    commentNumber += 1;
                }else if ("delete".equals(type)){
                    //评论数量减1
                    commentNumber -= 1;
                }
                //更新到数据库
                Answer newCommentNumberAnswer = new Answer();
                newCommentNumberAnswer.setAnswerId(moduleId);
                newCommentNumberAnswer.setCommentNumber(commentNumber);
                answerMapper.updateByPrimaryKeySelective(newCommentNumberAnswer);
            } else if (rootModuleCode == 3) {
                //如果是评论文章，在文章表中找到值为moduleId的article_id
                Article article = articleMapper.selectByPrimaryKey(moduleId);
                int commentNumber = article.getCommentNumber();
                if("add".equals(type)){
                    //评论数量加1
                    commentNumber += 1;
                }else if ("delete".equals(type)){
                    //评论数量减1
                    commentNumber -= 1;
                }
                //更新到数据库
                Article newCommentNumberArticle = new Article();
                newCommentNumberArticle.setArticleId(moduleId);
                newCommentNumberArticle.setCommentNumber(commentNumber);
                articleMapper.updateByPrimaryKeySelective(newCommentNumberArticle);
            } else if (rootModuleCode == 4) {
                //如果是评论想法，在想法表中找到值为moduleId的idea_id
                Idea idea = ideaMapper.selectByPrimaryKey(moduleId);
                int commentNumber = idea.getCommentNumber();
                if("add".equals(type)){
                    //评论数量加1
                    commentNumber += 1;
                }else if ("delete".equals(type)){
                    //评论数量减1
                    commentNumber -= 1;
                }
                //更新到数据库
                Idea newCommentNumberArticle = new Idea();
                newCommentNumberArticle.setIdeaId(moduleId);
                newCommentNumberArticle.setCommentNumber(commentNumber);
                ideaMapper.updateByPrimaryKeySelective(newCommentNumberArticle);
            }
            //处理回复数量
            if (moduleCode == 3 && record.getRootCommentId() != null){
                int commentId = record.getRootCommentId();
                Comment comment = commentMapper.selectByPrimaryKey(commentId);
                int responseNumber = comment.getResponseNumber();
                if("add".equals(type)){
                    //回复数量加1
                    responseNumber += 1;
                }else if ("delete".equals(type)){
                    //回复数量减1
                    responseNumber -= 1;
                }
                Comment newResponseNumberComment = new Comment();
                newResponseNumberComment.setCommentId(commentId);
                newResponseNumberComment.setResponseNumber(responseNumber);
                commentMapper.updateByPrimaryKeySelective(newResponseNumberComment);
            }

        } catch (Exception e) {
            log.error("评论数量更新出现异常", e);
        }
    }
    @Override
    public CommonResult insertSelective(Comment record) {
        try {
            String type = "add";
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            commentMapper.insertSelective(record);
            addOrDeleteComment(record, type);
        } catch (Exception e) {
            log.error("添加评论出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    //级联删除
    public void cascadeDummyDelete(Integer commentId, String type){
        int moduleCode = 3;
        if (commentId == null){
            return;
        }else {
            List<Comment> commentList = commentMapper.selectChildComment(moduleCode, commentId);
            for (Comment comment : commentList) {
                commentId = comment.getCommentId();
                cascadeDummyDelete(commentId, type);
                addOrDeleteComment(comment, type);
                commentMapper.dummyDeleteByPrimaryKey(commentId);
            }
        }
    }

    @Override
    public CommonResult dummyDeleteByPrimaryKey(Integer commentId) {
        String isExistSituation;
        try {
            String type = "delete";
            //级联删除该评论下的回复
            cascadeDummyDelete(commentId, type);
            //更新并删除该评论本身
            Comment record = commentMapper.selectByPrimaryKey(commentId);
            addOrDeleteComment(record, type);
            int isExist = commentMapper.dummyDeleteByPrimaryKey(commentId);
            if (isExist == 1) {
                isExistSituation = "成功";
            } else {
                isExistSituation = "不存在";
            }
        } catch (Exception e) {
            log.error("删除评论出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "调用成功", "级联删除评论" + commentId + isExistSituation);
    }

    @Override
    public CommonResult selectAllComment(Integer moduleCode, Integer moduleId, Integer pageNumber, Integer pageLength) {
        ResponseList returnRootResponseList = new ResponseList();
        try {
            ArrayList<Response> rootResponseList = new ArrayList<>();
            //以第一层评论数量做分页(参照知乎)
            int leverOneCommentNumber = commentMapper.selectCommentNumberByModuleCodeModuleId(moduleCode, moduleId);
            int totalPages = 0;
            if (leverOneCommentNumber%pageLength == 0){
                totalPages = leverOneCommentNumber/pageLength;
            }else {
                totalPages = leverOneCommentNumber/pageLength + 1;
            }
            returnRootResponseList.setTotalPages(totalPages);
            int lineNumber = (pageNumber - 1) * pageLength;
            //得到文章的第一层评论
            List<Comment> commentList = commentMapper.selectCommentByModuleCodeModuleId(moduleCode, moduleId, lineNumber, pageLength);
            //遍历文章的第一层评论
            for (Comment comment : commentList) {
                Response rootResponse = new Response();
                //取出第一层评论的comment_id，看是否该评论下module_id是否还有评论
                moduleId = comment.getCommentId();
                int userId = comment.getUserId();
                User user = userMapper.selectByPrimaryKey(userId);
                //类型为评论
                moduleCode = 3;
                /*//调用递归查找评论的方法
                recursionSelectComment(moduleCode, moduleId, comment);*/
                List<Comment> subCommentList = commentMapper.selectAllCommentByModuleCodeModuleId(moduleCode, moduleId);
                //包装子评论：回复者、被回复者
                ArrayList<Response> childResponseList = new ArrayList<>();
                for (Comment childComment : subCommentList) {
                    Response childResponse = new Response();
                    int childUserId = childComment.getUserId();
                    User childUser = userMapper.selectByPrimaryKey(childUserId);
                    childResponse.setComment(childComment);
                    childResponse.setReplyUser(childUser);
                    childResponse.setBeRepliedUser(user);
                    childResponseList.add(childResponse);
                }
                comment.setSubCommentList(childResponseList);
                //包装根
                rootResponse.setComment(comment);
                rootResponse.setReplyUser(user);
                rootResponseList.add(rootResponse);
            }
            returnRootResponseList.setResponseList(rootResponseList);
        } catch (Exception e) {
            log.error("查询所有评论时出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", returnRootResponseList);
    }

    /**
     * 递归查找评论的方法(取消使用)
     *//*
    public void recursionSelectComment(Integer moduleCode, Integer moduleId, Comment comment) {
        //查找该评论下的第一层评论
        List<Comment> subCommentList = commentMapper.selectAllCommentByModuleCodeModuleId(moduleCode, moduleId);
        comment.setSubCommentList(subCommentList);
        if (subCommentList.size() == 0) {
            return;
        } else {
            for (Comment subComment : subCommentList) {
                //取出第一层子评论的comment_id，看是否该评论下module_id是否还有评论
                moduleId = subComment.getCommentId();
                //类型为评论
                moduleCode = 3;
                recursionSelectComment(moduleCode, moduleId, subComment);
            }
        }
    }*/

    @Override
    public CommonResult selectChildComment(Integer moduleId, Integer pageNumber, Integer pageLength) {
        ResponseList responseList = new ResponseList();
        List<Response> responses = new ArrayList<>();
        try {
            //查询回复总数
            Comment rootComment = commentMapper.selectByPrimaryKey(moduleId);
            int responseNumber = rootComment.getResponseNumber();
            int totalPages = 0;
            if (responseNumber%pageLength == 0){
                totalPages = responseNumber/pageLength;
            }else {
                totalPages = responseNumber/pageLength + 1;
            }
            responseList.setTotalPages(totalPages);
            int lineNumber = (pageNumber - 1) * pageLength;
            //分页得到评论列表
            List<Comment> commentList = commentMapper.selectResponseByModuleId(moduleId, lineNumber, pageLength);
            //整合回复者和被回复者信息
            for (Comment comment : commentList) {
                //得到被评论的id，moduleCode应该为3
                int beCommentedId = comment.getModuleId();
                Response response = new Response();
                //去查找被评论的人
                int beCommentedUserId = commentMapper.selectBeCommentedUserId(beCommentedId);
                User beRepliedUser = userMapper.selectByPrimaryKey(beCommentedUserId);
                //得到评论者的信息
                int commentedUserId = comment.getUserId();
                User replyUser = userMapper.selectByPrimaryKey(commentedUserId);
                //包装
                response.setReplyUser(replyUser);
                response.setBeRepliedUser(beRepliedUser);
                response.setComment(comment);
                responses.add(response);
            }
            responseList.setResponseList(responses);
        } catch (Exception e) {
            log.error("查询回复时出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", responseList);
    }

}
