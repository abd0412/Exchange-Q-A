package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/4 15:47
 * @Version: 1.0
 */
@Mapper
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer problemId);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer problemId);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    /**
     * 查询人气问题
     * @param lineNumber
     * @param pageLength
     * @return
     */
    List<Problem> selectPopularProblem(@Param("lineNumber") Integer lineNumber, @Param("pageLength") Integer pageLength);

    /**
     * 查询最新问题
     * @param lineNumber
     * @param pageLength
     * @return
     */
    List<Problem> selectLatestProblem(@Param("lineNumber") Integer lineNumber, @Param("pageLength") Integer pageLength);
}