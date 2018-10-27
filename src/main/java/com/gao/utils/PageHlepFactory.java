package com.gao.utils;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;


public class PageHlepFactory {
    public PageHlepFactory() {
    }

    /**
     * 内部静态类
     */
    private static class PageHelpwerHandler {
        private static final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    }

    /**
     * 内部的静态返回方法
     *
     * @return
     */
    public static SqlSessionFactoryBean getSqlSessionFactoryBean() throws ClassNotFoundException {
        SqlSessionFactoryBean sqlSessionFactoryBean = PageHelpwerHandler.sqlSessionFactoryBean;
        sqlSessionFactoryBean.setDataSource(SimpleDateSource.instance());
//        配置分页拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
//        创建插件需要的参数集合
        Properties properties = new Properties();
//        配置数据库方言 oracle , mysql , mariadb , sqlite , hsqldb , postgresql , db2 , sqlserver , informix , h2 , sqlserver2012 , derby
        properties.setProperty("helperDialect", "mysql");
//        配置分页的合理化数据
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        return sqlSessionFactoryBean;
    }


}
