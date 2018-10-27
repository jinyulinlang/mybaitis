package com.gao.mappers;

import com.gao.model.TGrade;
import org.apache.ibatis.annotations.*;

/**
 * 多对一使用注解测试
 */
public interface TGradeAnnoMapper {
    /**
     * @param id
     * @return
     */
    @Select("select * from t_grade where id=#{id}")
    @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "grade_name", property = "gradeName"), @Result(column = "id", property = "tStudents", many = @Many(select = "com.gao.mappers.TStudentAnnMapper.findWitgAnnoByGradeId"))})
    TGrade findWithAnnoById(Integer id);

    /**
     * @param id
     * @return
     */
    @Select("select * from t_grade where id=#{id}")
    @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "grade_name", property = "gradeName")})
    TGrade findById(Integer id);

}