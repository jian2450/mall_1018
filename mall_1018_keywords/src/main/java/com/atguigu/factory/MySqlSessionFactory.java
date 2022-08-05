package com.atguigu.factory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author jian
 * @create 2022-08-04 18:06
 */
public class MySqlSessionFactory {

    public static SqlSessionFactory getMyF() {

        InputStream is = MySqlSessionFactory.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);

        return build;
    }

}
