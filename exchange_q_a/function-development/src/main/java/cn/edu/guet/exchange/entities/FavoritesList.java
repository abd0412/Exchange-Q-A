package cn.edu.guet.exchange.entities;

import java.util.List;

/**
 * @Author: cyan
 * @Description:
 * @Date: 2021/11/9 21:47
 * @Version: 1.0
 */
public class FavoritesList {
    private List<Favorites> favoritesList;

    public List<Favorites> getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(List<Favorites> favoritesList) {
        this.favoritesList = favoritesList;
    }
}
