package com.soft.propex;

import java.util.Properties;
import java.util.Set;

public class PropDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 存储键值对
        properties.setProperty("host", "loaclhost");
        properties.setProperty("port", "3306");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        System.out.println(properties);
        // 获取port键对应的值
        String value = properties.getProperty("port");
        System.out.println(value);
        // 所有的键存储到Set集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "==" + properties.getProperty(key));
        }
    }
}
