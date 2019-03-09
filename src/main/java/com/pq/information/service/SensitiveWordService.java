package com.pq.information.service;


import com.pq.information.entity.SensitiveWord;

/**
 * Created by lt on 17/8/3.
 */
public interface SensitiveWordService {

    /**
     * 是否含有敏感词
     * @param txt
     * @return
     */
    boolean isHaveSensitiveWord(String txt);

    /**
     * 检索敏感词
     * @param word
     * @return
     */
    SensitiveWord getByWord(String word);

    /**
     * 删除敏感词
     * @param id
     */
    void deleteById(long id);

}
