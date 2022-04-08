package cn.edu.guet.exchange.service;

import cn.edu.guet.exchange.entities.CommonResult;
import cn.edu.guet.exchange.entities.Favorites;

/**
 * @Author: cyan
 * @Description:
 * @Date: 2021/11/9 20:33
 * @Version: 1.0
 */
public interface FavoritesService {
    /**
     * 添加收藏夹
     * @param record
     * @return
     */
    CommonResult insertSelective(Favorites record);

    /**
     * 查询用户的收藏夹
     * @param userId
     * @return
     */
    CommonResult selectFavoritesByUserId(int userId);

}
