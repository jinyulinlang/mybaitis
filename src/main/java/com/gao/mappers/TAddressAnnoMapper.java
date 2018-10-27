package com.gao.mappers;

import com.gao.model.TAddress;
import org.apache.ibatis.annotations.Select;

public interface TAddressAnnoMapper {
    @Select("select * from t_address where id=#{id}")
    TAddress findById(Integer id);
}
