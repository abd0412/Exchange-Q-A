package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/10 14:16
 * @Version:    1.0
 */
@Mapper
public interface CollectMapper {
    int deleteByPrimaryKey(Integer collectId);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer collectId);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    /**
     * 查询某用户对某对象的收藏情况
     * @param userId
     * @param moduleCode
     * @param moduleId
     * @return
     */
    List<Collect> selectCollectListByParam(@Param("userId") Integer userId, @Param("moduleCode") Integer moduleCode, @Param("moduleId") Integer moduleId);
}