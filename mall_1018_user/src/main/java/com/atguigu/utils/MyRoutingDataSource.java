package com.atguigu.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author jian
 * @create 2022-07-27 2:20
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    private static ThreadLocal<String> key = new ThreadLocal<String>();

    public static String getKey() {
        return key.get();
    }

    public static void setKey(String key_in) {
        key.set(key_in);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return this.key.get();
    }
}
