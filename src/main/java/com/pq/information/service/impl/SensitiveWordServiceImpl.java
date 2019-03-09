package com.pq.information.service.impl;

import com.pq.information.entity.SensitiveWord;
import com.pq.information.mapper.SensitiveWordMapper;
import com.pq.information.service.SensitiveWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by lr on 17/3/28.
 */
@Service
public class SensitiveWordServiceImpl implements SensitiveWordService {

    @Autowired
    private SensitiveWordMapper sensitiveWordMapper;

    private static final long REFRESH_SECONDS = 1000 * 60 * 30L;

    private static final long LAST_UPDATE_TIME = 0L;

    private final static Logger LOGGER = LoggerFactory.getLogger(SensitiveWordServiceImpl.class);

    private static HashMap sensitiveWordMap = null;

    private synchronized void init() {
        if (sensitiveWordMap != null) {
            return;
        }
        List<SensitiveWord> sensitiveWords = sensitiveWordMapper.selectAll();
        sensitiveWordMap = new HashMap();
        String key = null;
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        Set<String> keyWordSet = new HashSet<>();
        for (SensitiveWord sensitiveWord : sensitiveWords) {
            keyWordSet.add(sensitiveWord.getWord());
        }
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();    //关键字
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);       //转换成char型
                Object wordMap = nowMap.get(keyChar);       //获取

                if (wordMap != null) {        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }

    }


    @Override
    public boolean isHaveSensitiveWord(String txt) {
        long now = System.currentTimeMillis();
        if (now - LAST_UPDATE_TIME > REFRESH_SECONDS) {
            sensitiveWordMap = null;
        }
        if (sensitiveWordMap == null) {
            init();
        }
        for (int i = 0; i < txt.length(); i++) {
            int length = checkSensitiveWord(txt, i);
            if (length > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public SensitiveWord getByWord(String word) {
        return sensitiveWordMapper.selectByWord(word);
    }

    @Override
    public void deleteById(long id) {
        sensitiveWordMapper.deleteByPrimaryKey(id);
    }


    private int checkSensitiveWord(String txt, int beginIndex) {
        boolean flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
        int matchFlag = 0;     //匹配标识数默认为0
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);     //获取指定key
            if (nowMap != null) {     //存在，则判断是否为最后一个
                matchFlag++;     //找到相应key，匹配标识+1
                if ("1".equals(nowMap.get("isEnd"))) {       //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                }
            } else {     //不存在，直接返回
                break;
            }
        }
        if (matchFlag < 2 || !flag) {        //长度必须大于等于1，为词
            matchFlag = 0;
        }
        return matchFlag;
    }
}
