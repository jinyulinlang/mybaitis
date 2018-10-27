package com.gao.mappers;

import com.gao.model.TStudent;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

public class StudentDynaSqllProvider {

    public String insertStudent(final TStudent tStudent) {
        return new SQL() {
            {
                INSERT_INTO("t_student");
                if (null != tStudent.getName()) {
                    VALUES("name", "#{name}");
                }
                if (tStudent.getAge() != null) {
                    VALUES("age", "#{age}");
                }
                if (null != tStudent.gettAddress().getId()) {
                    VALUES("address_id", tStudent.gettAddress().getId() + "");
                }
                if (null != tStudent.gettGrade().getId()) {
                    VALUES("grade_id", tStudent.gettGrade().getId() + "");
                }
            }
        }.toString();
    }

    public String updateStudent(final TStudent tStudent) {
        return new SQL() {
            {
                UPDATE("t_student");
                if (null != tStudent.getName()) {
                    SET("name=#{name}");
                }
                if (tStudent.getAge() != null) {
                    SET("age=#{age}");
                }
                WHERE("id=#{id}");
            }
        }.toString();

    }

    public String deleteStudent(final Integer id) {
        return new SQL() {
            {
                DELETE_FROM("t_student");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String findStudentById(Integer id) {
        return new SQL() {
            {
                SELECT("*");
                FROM("t_student");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String findStudents(Map<String, Object> bean) {

        return new SQL() {
            {
                SELECT("*");
                FROM("t_student");

                StringBuilder sb = new StringBuilder();
                if (bean.get("name") != null) {
                    sb.append("and name=" + bean.get("name"));

                }
                if (bean.get("age") != null) {
                    sb.append(" and age=" + bean.get("age"));

                }
                if (!sb.toString().isEmpty()) {
                    WHERE(sb.toString().replaceFirst("and", ""));
                }
            }


        }.toString();
    }
}
