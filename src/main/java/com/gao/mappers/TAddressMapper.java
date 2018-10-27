package com.gao.mappers;

import com.gao.model.TAddress;

public interface TAddressMapper {
    int insert(TAddress record);

    int insertSelective(TAddress record);

    TAddress findAddressById1(Integer id);

    TAddress findAddressById2(Integer id);
    TAddress findAddressById3(Integer id);
}