package com.pq.information.mapper;

import com.pq.information.entity.Information;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    Information selectByPrimaryKey(Long id);

    List<Information> selectAll();

    int updateByPrimaryKey(Information record);

    List<Information> selectList(@Param("offset") Integer offset,@Param("size") Integer size);
}