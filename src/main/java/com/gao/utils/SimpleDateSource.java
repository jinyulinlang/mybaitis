package com.gao.utils;

import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

public class SimpleDateSource implements DataSource {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(SimpleDateSource.class);
    private static final String dirverClassName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://192.168.235.128:3306/db_mybatis?characterEncoding=utf8&autoReconnect=true&useSSL=false";
    private static final String username = "root";
    private static final String password = "123456";
    //连接池
    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
    private static SimpleDateSource instance = new SimpleDateSource();

    static {
        try {
            Class.forName(dirverClassName);
        } catch (ClassNotFoundException e) {
            log.error("找不到驱动类！", e);
        }
    }

    private SimpleDateSource() {
    }

    /**
     * 获取数据源单例
     *
     * @return 数据源单例
     */
    public  static SimpleDateSource instance() {
        if (instance == null) {
            instance = new SimpleDateSource();
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        synchronized (pool) {
            if (pool.size() > 0) {
                return pool.removeFirst();
            } else {
                return getConnection(username,password);
            }
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
