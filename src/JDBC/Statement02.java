package JDBC;
/**
 * Statement02 有sql注入问题
 */

import java.sql.*;

public class Statement02 {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMySQLConnect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            //String sql = "insert into user(name ,pwd,regTime) values ('eee','123456','2019-5-5')";

            //sql注入
            String where = "4 or 1=1";
            String sql = "delete from user where id ="+where+"";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    }
}
