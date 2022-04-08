package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.*;
import cn.edu.guet.exchange.mapper.CollectMapper;
import cn.edu.guet.exchange.mapper.FavoritesMapper;
import cn.edu.guet.exchange.service.CollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author: cyan
 * @Description: 收藏
 * @Date: 2021/11/9 22:10
 * @Version: 1.0
 */
@Service
@Slf4j
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private FavoritesMapper favoritesMapper;

    public void addOrDeleteCollect(Collect record, String Type) {
        try {
            //更新用户收藏夹的收藏内容数量
            int favoritesId = record.getFavoritesId();
            Favorites favorites = favoritesMapper.selectByPrimaryKey(favoritesId);
            int contentNumber = favorites.getContentNumber();
            if("add".equals(Type)){
                contentNumber += 1;
            }else if ("delete".equals(Type)){
                contentNumber -= 1;
            }
            //更新收藏夹更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            //进行更新
            Favorites newFavorites = new Favorites();
            newFavorites.setFavoritesId(favoritesId);
            newFavorites.setContentNumber(contentNumber);
            newFavorites.setUpdateTime(updateTime);
            favoritesMapper.updateByPrimaryKeySelective(newFavorites);
        } catch (Exception e) {
            log.error("收藏更新出现异常", e);
        }
    }

    @Override
    public CommonResult insertSelective(Collect record) {
        try {
            String Type = "add";
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            collectMapper.insertSelective(record);
            addOrDeleteCollect(record, Type);
        } catch (Exception e) {
            log.error("添加收藏出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    @Override
    public CommonResult selectAllCollect(int userId, int moduleCode, int moduleId) {
        CollectList returnCollectList = new CollectList();
        try {
            List<Collect> collectList = collectMapper.selectCollectListByParam(userId, moduleCode, moduleId);
            returnCollectList.setCollectList(collectList);
        } catch (Exception e) {
            log.error("查询收藏出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", returnCollectList);
    }

    @Override
    public CommonResult deleteByPrimaryKey(int collectId) {
        String isExistSituation;
        try {
            //先将关系信息查询出来，用于修改数量
            Collect collect = collectMapper.selectByPrimaryKey(collectId);
            String type = "delete";
            addOrDeleteCollect(collect, type);
            int isExist = collectMapper.deleteByPrimaryKey(collectId);
            if (isExist == 1) {
                isExistSituation = "成功";
            } else {
                isExistSituation = "不存在";
            }
        } catch (Exception e) {
            log.error("删除取消关系"+ collectId +"出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "调用成功", "取消收藏" + collectId + isExistSituation);
    }
}
