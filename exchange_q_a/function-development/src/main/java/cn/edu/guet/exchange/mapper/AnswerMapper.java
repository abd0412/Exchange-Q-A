package cn.edu.guet.exchange.mapper;

import cn.edu.guet.exchange.entities.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: cyan
 * @Description: ${description}
 * @Date: 2021/11/5 15:33
 * @Version: 1.0
 */
@Mapper
public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    List<Answer> selectAnswerByProblemId(@Param("problemId") Integer problemId, @Param("lineNumber") Integer lineNumber, @Param("pageLength") Integer pageLength);
}