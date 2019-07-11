package JDBC;
/**
 * PreparedStatement
 * 关闭顺序 ResultSet--->PreparedStatement--->Connection
 */

import java.sql.*;

public class PreparedStatement03 {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert INTO USER(NAME,PWD,regtime) VALUES (?,?,?)";
            String sql2 = "delete  from user";
            String sql3 = "select id,name,pwd from user where id>?";
            ps = conn.prepareStatement(sql3);
            ps.setObject(1,2);
//            ps.setString(1,"ccc");
//            ps.setString(2,"123456");
//            ps.setDate(3,new Date(System.currentTimeMillis()));
            //返回Boolean类型
            //ps.execute();
            //返回影响数量
//            int count = ps.executeUpdate();
//            System.out.println(count);

            //返回结果集
            rs =  ps.executeQuery();
             while (rs.next()){
                 System.out.println(rs.getString(1)+"---"+rs.getString(2)
                 +"---"+rs.getString(3));

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.stop(rs,ps,conn);

        }
    }

}
