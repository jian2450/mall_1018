package com.atguigu.service;

import com.atguigu.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jian
 * @create 2022-08-07 11:06
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public void log(String string) {
        indexMapper.log(string);
    }
}
