package com.pq.information.mapper;

import com.pq.information.entity.SensitiveWord;

import java.util.List;

public interface SensitiveWordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SensitiveWord record);

    SensitiveWord selectByPrimaryKey(Long id);

    List<SensitiveWord> selectAll();

    int updateByPrimaryKey(SensitiveWord record);

    SensitiveWord selectByWord(String word);
}