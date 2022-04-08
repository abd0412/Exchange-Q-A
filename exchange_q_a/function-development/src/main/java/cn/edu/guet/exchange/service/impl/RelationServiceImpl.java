package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.*;
import cn.edu.guet.exchange.mapper.*;
import cn.edu.guet.exchange.service.RelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: cyan
 * @Description:
 * @Date: 2021/11/8 15:17
 * @Version: 1.0
 */
@Service
@Slf4j
public class RelationServiceImpl implements RelationService {
    @Resource
    private RelationMapper relationMapper;
    @Resource
    private ProblemMapper problemMapper;
    @Resource
    private AnswerMapper answerMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private IdeaMapper ideaMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private FavoritesMapper favoritesMapper;

    /**
     * 对对象进行操作时，更新数量的方法
     * @param record
     * @param operate
     * @return
     */
    public void addOrDeleteRelation(Relation record, String operate) {
        try {
            //得到对象类型
            int moduleCode = record.getModuleCode();
            //得到对象id
            int moduleId = record.getModuleId();
            //得到操作类型
            int relationType = record.getRelationType();
            //下面对涉及数量的进行更新
            if (moduleCode == 1) {
                Problem problem = problemMapper.selectByPrimaryKey(moduleId);
                //一、如果是问题
                if (relationType == 1) {
                    //1、如果是关注问题的操作
                    //获取问题的关注人数
                    int followerNumber = problem.getFollowerNumber();
                    if ("add".equals(operate)){
                        followerNumber += 1;
                    }else if ("delete".equals(operate)){
                        followerNumber -= 1;
                    }
                    //更新关注人数
                    Problem newFollowerNumberProblem = new Problem();
                    newFollowerNumberProblem.setProblemId(moduleId);
                    newFollowerNumberProblem.setFollowerNumber(followerNumber);
                    problemMapper.updateByPrimaryKeySelective(newFollowerNumberProblem);
                } else if (relationType == 2) {
                    //2、如果是好问题操作
                    //获取好问题数量
                    int goodQuestionNumber = problem.getGoodQuestionNumber();
                    if ("add".equals(operate)){
                        goodQuestionNumber += 1;
                    }else if ("delete".equals(operate)){
                        goodQuestionNumber -= 1;
                    }
                    //更新好问题数量
                    Problem newGoodQuestionNumberProblem = new Problem();
                    newGoodQuestionNumberProblem.setProblemId(moduleId);
                    newGoodQuestionNumberProblem.setGoodQuestionNumber(goodQuestionNumber);
                    problemMapper.updateByPrimaryKeySelective(newGoodQuestionNumberProblem);
                }
            } else if (moduleCode == 2) {
                //二、如果是回答
                if (relationType == 1) {
                    //1、赞同回答
                    //获取赞同回答的数量
                    Answer answer = answerMapper.selectByPrimaryKey(moduleId);
                    int agreeNumber = answer.getAgreeNumber();
                    if ("add".equals(operate)){
                        agreeNumber += 1;
                    }else if ("delete".equals(operate)){
                        agreeNumber -= 1;
                    }
                    //更新赞同回答的数量
                    Answer newAgreeNumberAnswer = new Answer();
                    newAgreeNumberAnswer.setAnswerId(moduleId);
                    newAgreeNumberAnswer.setAgreeNumber(agreeNumber);
                    answerMapper.updateByPrimaryKeySelective(newAgreeNumberAnswer);
                }
            } else if (moduleCode == 3) {
                //三、如果是评论
                if (relationType == 1) {
                    //1、如果是赞评论
                    //获取评论的点赞数
                    Comment comment = commentMapper.selectByPrimaryKey(moduleId);
                    int approvalNumber = comment.getApprovalNumber();
                    if ("add".equals(operate)){
                        approvalNumber += 1;
                    }else if ("delete".equals(operate)){
                        approvalNumber -= 1;
                    }
                    //更新评论的点赞数
                    Comment approvalNumberComment = new Comment();
                    approvalNumberComment.setCommentId(moduleId);
                    approvalNumberComment.setApprovalNumber(approvalNumber);
                    commentMapper.updateByPrimaryKeySelective(approvalNumberComment);
                }
            } else if (moduleCode == 4) {
                //四、如果是文章
                if (relationType == 1) {
                    //1、如果是赞同文章
                    //获取赞同文章的数量
                    Article article = articleMapper.selectByPrimaryKey(moduleId);
                    int agreeNumber = article.getAgreeNumber();
                    if ("add".equals(operate)){
                        agreeNumber += 1;
                    }else if ("delete".equals(operate)){
                        agreeNumber -= 1;
                    }
                    //更新文章的赞同数
                    Article newAgreeNumberArticle = new Article();
                    newAgreeNumberArticle.setArticleId(moduleId);
                    newAgreeNumberArticle.setAgreeNumber(agreeNumber);
                    articleMapper.updateByPrimaryKeySelective(newAgreeNumberArticle);
                }
            } else if (moduleCode == 5) {
                //五、如果是想法
                if (relationType == 1) {
                    //1、如果是鼓掌想法
                    //获取鼓掌想法的数量
                    Idea idea = ideaMapper.selectByPrimaryKey(moduleId);
                    int applauseNumber = idea.getApplauseNumber();
                    if ("add".equals(operate)){
                        applauseNumber += 1;
                    }else if ("delete".equals(operate)){
                        applauseNumber -= 1;
                    }
                    //更新想法的鼓掌数
                    Idea newApplauseNumberIdea = new Idea();
                    newApplauseNumberIdea.setIdeaId(moduleId);
                    newApplauseNumberIdea.setApplauseNumber(applauseNumber);
                    ideaMapper.updateByPrimaryKeySelective(newApplauseNumberIdea);
                }
            } else if (moduleCode == 6) {
                //六、如果是其他用户
                if (relationType == 1) {
                    //关注用户
                    //获取登录用户的关注用户的关注者数量
                    User user = userMapper.selectByPrimaryKey(moduleId);
                    int followerNumber = user.getFollowerNumber();
                    if ("add".equals(operate)){
                        followerNumber += 1;
                    }else if ("delete".equals(operate)){
                        followerNumber -= 1;
                    }
                    //更新数量
                    User newFollowerNumberUser = new User();
                    newFollowerNumberUser.setUserId(moduleId);
                    newFollowerNumberUser.setFollowerNumber(followerNumber);
                    userMapper.updateByPrimaryKeySelective(newFollowerNumberUser);
                }
            } else if (moduleCode == 7) {
                //七、如果是其他用户的收藏夹
                if (relationType == 1) {
                    //关注其他用户的某个收藏夹
                    //获取其他用户的某个收藏夹的关注者数量
                    Favorites favorites = favoritesMapper.selectByPrimaryKey(moduleId);
                    int followerNumber = favorites.getFollowerNumber();
                    if ("add".equals(operate)){
                        followerNumber += 1;
                    }else if ("delete".equals(operate)){
                        followerNumber -= 1;
                    }
                    //更新数量
                    Favorites newFollowerNumberFavorites = new Favorites();
                    newFollowerNumberFavorites.setFavoritesId(moduleId);
                    newFollowerNumberFavorites.setFollowerNumber(followerNumber);
                    favoritesMapper.updateByPrimaryKeySelective(newFollowerNumberFavorites);
                }
            }
        } catch (Exception e) {
            log.error(operate + "关系时出现异常", e);
        }
    }

    @Override
    public CommonResult insertSelective(Relation record) {
        try {
            String operate = "add";
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            relationMapper.insertSelective(record);
            addOrDeleteRelation(record, operate);
        } catch (Exception e) {
            log.error("添加关系时出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "操作成功", record);
    }

    @Override
    public CommonResult selectObjectRelation(int userId, Integer moduleCode, Integer moduleId) {
        RelationList returnRelationList = new RelationList();
        try {
            List<Relation> relationList = relationMapper.selectObjectRelation(userId, moduleCode, moduleId);
            returnRelationList.setRelationList(relationList);
        } catch (Exception e) {
            log.error("查询关系出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", returnRelationList);
    }

    @Override
    public CommonResult deleteByPrimaryKey(int relationId) {
        String isExistSituation;
        try {
            //先将关系信息查询出来，用于修改数量
            Relation relation = relationMapper.selectByPrimaryKey(relationId);
            String operate = "delete";
            addOrDeleteRelation(relation, operate);
            int isExist = relationMapper.deleteByPrimaryKey(relationId);
            if (isExist == 1) {
                isExistSituation = "成功";
            } else {
                isExistSituation = "不存在";
            }
        } catch (Exception e) {
            log.error("删除操作关系出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "调用成功", "取消操作" + relationId + isExistSituation);
    }
}
