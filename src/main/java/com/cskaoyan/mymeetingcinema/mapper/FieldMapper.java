package com.cskaoyan.mymeetingcinema.mapper;

import com.cskaoyan.mymeetingcinema.model.generator.Field;
import com.cskaoyan.mymeetingcinema.model.generator.FieldExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FieldMapper {
    long countByExample(FieldExample example);

    int deleteByExample(FieldExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(Field record);

    int insertSelective(Field record);

    List<Field> selectByExample(FieldExample example);

    Field selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") Field record, @Param("example") FieldExample example);

    int updateByExample(@Param("record") Field record, @Param("example") FieldExample example);

    int updateByPrimaryKeySelective(Field record);

    int updateByPrimaryKey(Field record);
}