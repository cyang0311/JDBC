package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批处理
 */
public class Batch04 {
    public static void main(String[] args) {

        Connection conn = JDBCUtil.getMySQLConnect();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //提交事务  改为手动提交
            conn.setAutoCommit(false);
            long start = System.currentTimeMillis();
            stmt = conn.createStatement();

            for (int i = 0; i < 50; i++) {
                stmt.addBatch("insert into user (name ,pwd, regtime) values ('user"+i+"',123,now())");
            }
            stmt.executeBatch();
            conn.commit();//提交事务
            long end = System.currentTimeMillis();
            System.out.println("耗时----->"+(end-start));
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            JDBCUtil.stop(rs,stmt,conn);
        }
    }
}
