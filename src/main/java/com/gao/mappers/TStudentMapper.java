package com.gao.mappers;

import com.gao.model.TStudent;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TStudentMapper {
    /**
     * 新增无条件
     *
     * @param record
     * @return
     */
    int insert(TStudent record);

    /**
     * 有条件的新增
     *
     * @param record
     * @return
     */
    int insertSelective(TStudent record);

    /**
     * 修改
     *
     * @param student
     * @return
     */
    int update(TStudent student);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    TStudent findById(Integer id);

    /**
     * 查找全部学生
     *
     * @return
     */
    List<TStudent> find();

    /**
     * 通过Id查找带地址的学生信息
     *
     * @param id
     * @return
     */
    TStudent findStudentWithAddress(Integer id);

    TStudent findStudentWithAddress3(Integer id);

    TStudent findStudentWithAddress4(Integer id);

    TStudent findStudentWithAddress5(Integer id);

    TStudent findStudentWithAddressAndGradeById2(Integer id);

    List<TStudent> findStudentByGradeId2(Integer gradeId);

    List<TStudent> findStudentByGradeId3(Integer gradeId);
    List<TStudent> findStudentWithPage(RowBounds rb);


}