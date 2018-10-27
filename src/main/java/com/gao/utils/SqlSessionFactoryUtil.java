package com.gao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 单例模式创建一个工厂类
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            InputStream is = null;
            try {
                is = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return sqlSessionFactory;
    }

    /**
     * 打开一个会话连接
     *
     * @return
     */
    public static SqlSession openSession() {
        return getSqlSessionFactory().openSession();

    }
}
