package com.gao.mappers;

import com.gao.model.TStudent;
import com.gao.model.TVistor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TVistorMapper {
    @Insert("insert into t_vistor values (null,#{name},#{age})")
    int insert(TVistor tVistor);

    @Update("update t_vistor set name=#{name},age=#{age} where id=#{id}")
    int update(TVistor tVistor);

    @Delete("delete from t_vistor where id=#{id}")
    int delete(Integer id);

    @Select("select * from t_vistor")
    List<TVistor> findAll();

    @Select("select * from t_vistor where id=#{id}")
    TVistor findById(Integer id);





}