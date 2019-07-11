package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务四个特点
 * 1 原子性----事务内的操作为一个整体 要么全成功要么全失败
 * 2 一致性----事务失败后  回滚到事务开始前的状态
 * 3 隔离性----A事务提交后，B才能查看A的修改
 * 4 持久性----事务执行后，对系统的影响是永久的
 */
public class RollBack05 {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement psmt = null;

        try {
            conn.setAutoCommit(false);
            String sql = "insert into user(name,pwd) values (?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setObject(1,"aaa");
            psmt.setObject(2,"123");
            psmt.execute();

            String sql2= "insert into user(name,pwd) values (?,?)";
            psmt = conn.prepareStatement(sql2);
            psmt.setObject(1,"bbb");
            psmt.setObject(2,"123");
            psmt.execute();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            JDBCUtil.stop(psmt,conn);
        }
    }
}
