package com.jian.test;


import com.google.gson.Gson;
import com.jian.bean.Class1;
import com.jian.mapper.T_MALL_CLASS_1_mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-09 17:05
 */
public class TestClass1 {

    @Test
    public void test() throws IOException {
        //获取sqlSession
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession();
        //获取mapper
        T_MALL_CLASS_1_mapper class_1_mapper = session.getMapper(T_MALL_CLASS_1_mapper.class);
        //操作获取数据
        List<Class1> class1List = class_1_mapper.getList();
        System.out.println(class1List.size());

        //创建gson对象
        Gson gson = new Gson();
        //转json
        String class1str = gson.toJson(class1List);

        //生成静态文件
        FileOutputStream out = new FileOutputStream("d:/work/resources/class_1.js");
        out.write(class1str.getBytes());
        out.close();
    }
}
