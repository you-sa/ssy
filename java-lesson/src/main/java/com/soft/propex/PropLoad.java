package com.soft.propex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropLoad {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        // 通过IO读取外部属性文件，注意路径
        InputStream in = PropLoad.class.getResourceAsStream("config/database.properties");
        prop.load(in);

        // 所有的键存储到Set集合
        Set<String> keySet = prop.stringPropertyNames();
        // 遍历keySet,获取对应的值
        for (String key : keySet) {
            System.out.println(key + ":" + prop.getProperty(key));
        }
    }
}
