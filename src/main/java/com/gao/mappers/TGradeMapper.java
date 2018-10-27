package com.gao.mappers;

import com.gao.model.TGrade;

public interface TGradeMapper {
    int insert(TGrade record);

    int insertSelective(TGrade record);

    TGrade findGradeById2(Integer id);

    TGrade findGradeById1(Integer id);

    TGrade findGadeById3(Integer id);
}