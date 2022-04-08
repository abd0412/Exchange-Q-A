package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Relation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/8 22:19
 * @Version: 1.0
 */
@Mapper
public interface RelationMapper {
    int deleteByPrimaryKey(Integer relationId);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(Integer relationId);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);

    /**
     * 查询用户对对象的所有操作
     *
     * @param userId
     * @param moduleCode
     * @param moduleId
     * @return
     */
    List<Relation> selectObjectRelation(@Param("userId") Integer userId, @Param("moduleCode") Integer moduleCode, @Param("moduleId") Integer moduleId);
}