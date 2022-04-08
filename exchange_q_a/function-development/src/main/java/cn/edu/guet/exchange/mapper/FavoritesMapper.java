package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Favorites;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/9 20:17
 * @Version: 1.0
 */
@Mapper
public interface FavoritesMapper {
    int deleteByPrimaryKey(Integer favoritesId);

    int insert(Favorites record);

    int insertSelective(Favorites record);

    Favorites selectByPrimaryKey(Integer favoritesId);

    int updateByPrimaryKeySelective(Favorites record);

    int updateByPrimaryKey(Favorites record);

    /**
     * 根据用户id查询该用户的收藏夹
     * @param userId
     * @return
     */
    List<Favorites> selectFavoritesByUserId(Integer userId);
}