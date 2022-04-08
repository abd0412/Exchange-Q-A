package cn.edu.guet.exchange.service.impl;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Favorites;
import cn.edu.guet.exchange.entities.FavoritesList;
import cn.edu.guet.exchange.mapper.FavoritesMapper;
import cn.edu.guet.exchange.service.FavoritesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author: cyan
 * @Description: 收藏夹
 * @Date: 2021/11/9 20:46
 * @Version: 1.0
 */
@Service
@Slf4j
public class FavoritesServiceImpl implements FavoritesService {
    @Resource
    private FavoritesMapper favoritesMapper;
    @Override
    public CommonResult insertSelective(Favorites record) {
        try {
            //生成添加时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = dateFormat.format(date);
            record.setCreateTime(createTime);
            //添加
            favoritesMapper.insertSelective(record);
        } catch (Exception e){
            log.error("添加收藏夹出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "添加成功", record);
    }

    @Override
    public CommonResult selectFavoritesByUserId(int userId) {
        FavoritesList returnFavoritesList = new FavoritesList();
        try {
            List<Favorites> favoritesList = favoritesMapper.selectFavoritesByUserId(userId);
            returnFavoritesList.setFavoritesList(favoritesList);
        } catch (Exception e){
            log.error("查询收藏夹出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", returnFavoritesList);
    }
}
