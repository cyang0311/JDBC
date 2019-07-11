package JDBC;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public  class JDBCUtil {

    static Properties pros = null;//加载资源文件信息

    static {
        pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("JDBC/dbSource"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Connection getMySQLConnect(){
        try {
            //加载类
            Class.forName(pros.getProperty("mysqlDriver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //建立连接
        String DRIVER_URL = pros.getProperty("mysqlURL");
        String USERNAME = pros.getProperty("mysqlUser");
        String password = pros.getProperty("mysqlPwd");
        try {
            return DriverManager.getConnection(DRIVER_URL,USERNAME,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void stop(ResultSet rs, Statement stmt, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    static void stop(ResultSet rs, PreparedStatement ps, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void stop(Statement stmt, Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void stop(PreparedStatement ps, Connection conn){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
