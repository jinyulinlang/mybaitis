package com.gao.mappers;

import com.gao.model.TEmployee;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public interface TEmployeeMapper {


    int insert(TEmployee record);

    int insertSelective(TEmployee record);

    List<TEmployee> findEmployees1(Map<String, Object> bean);

    List<TEmployee> findEmployees2(Map<String, Object> bean);

    List<TEmployee> findEmployees3(Map<String, Object> bean);

    List<TEmployee> findEmployees4(Map<String, Object> bean);

    List<TEmployee> findEmployees5(Map<String, Object> bean);

    void update(TEmployee employee);
}