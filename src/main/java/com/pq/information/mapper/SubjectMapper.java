package com.pq.information.mapper;

import com.pq.information.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    Subject selectByPrimaryKey(Long id);

    List<Subject> selectAll();

    int updateByPrimaryKey(Subject record);

    List<Subject> selectValid(@Param("offset") int offset,@Param("size") int size);

}