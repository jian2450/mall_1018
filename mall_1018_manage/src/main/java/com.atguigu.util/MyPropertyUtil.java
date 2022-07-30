package com.atguigu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @Description 加载属性文件的工具类
 * @author jian
 * @date 2022年7月11日下午12:38:37
 *
 */
public class MyPropertyUtil {

	public static String getProperty(String pro, String key) {
		
		Properties properties = new Properties();
		
		InputStream is = MyPropertyUtil.class.getClassLoader().getResourceAsStream(pro);
		
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String property = properties.getProperty(key);
		return property;
	}
	
}
