package com.gao.mappers;

import com.gao.model.TStudent;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface TStudentAnnMapper {
    @Select("select * from t_student where id=#{id}")
    @Results({@Result(id = true, column = "id", property = "id", jdbcType = JdbcType.INTEGER), @Result(column = "name", property = "name"), @Result(column = "age", property = "age"), @Result(column = "address_id", property = "tAddress", one = @One(select = "com.gao.mappers.TAddressAnnoMapper.findById"))})
    TStudent findWithAnotationById(Integer id);

    @Select("select * from t_student where grade_id=#{gradeId}")
    @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "name", property = "name"), @Result(column = "age", property = "age"), @Result(column = "address_id", property = "tAddress", one = @One(select = "com.gao.mappers.TAddressAnnoMapper.findById"))})
    List<TStudent> findWitgAnnoByGradeId(Integer gradeId);

    @Select("select * from t_student where id=#{id}")
    @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "name", property = "name"), @Result(column = "age", property = "age"), @Result(column = "address_id", property = "tAddress", one = @One(select = "com.gao.mappers.TAddressAnnoMapper.findById")), @Result(column = "grade_id", property = "tGrade", many = @Many(select = "com.gao.mappers.TGradeAnnoMapper.findById"))})
    TStudent findWithAnnoAndAddressAndGradeById(Integer id);

    @InsertProvider(type = StudentDynaSqllProvider.class, method = "insertStudent")
    int insertStudent(TStudent tStudent);

    @UpdateProvider(type = StudentDynaSqllProvider.class, method = "updateStudent")
    int updateStudent(TStudent tStudent);

    @DeleteProvider(type = StudentDynaSqllProvider.class, method = "deleteStudent")
    int deleteStudent(Integer id);

    @SelectProvider(type = StudentDynaSqllProvider.class, method = "findStudentById")
    TStudent findStudentById(Integer id);

    @SelectProvider(type = StudentDynaSqllProvider.class, method = "findStudents")
    List<TStudent> findStudents(Map<String, Object> bean);
}
