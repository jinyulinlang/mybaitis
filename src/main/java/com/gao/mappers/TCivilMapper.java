package com.gao.mappers;

import com.gao.model.TCivilWithBLOBs;

public interface TCivilMapper {
    int insert(TCivilWithBLOBs record);

    int insertSelective(TCivilWithBLOBs record);

    TCivilWithBLOBs findTCivilById1(Integer id);
}