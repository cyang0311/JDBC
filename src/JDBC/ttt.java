package JDBC;

import java.sql.*;

public class ttt {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test01","root","123456");
            conn.setAutoCommit(false);

            String sql = "insert into user (name,pwd,regtime,lastLogintime) values (?,?,?,?)";
//            stmt = conn.createStatement();
//            stmt.executeQuery(sql);

            Date date = new Date(System.currentTimeMillis());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            ps = conn.prepareStatement(sql);
            ps.setObject(1,"ccc");
            ps.setObject(2,123);
            ps.setDate(3,date);
            ps.setTimestamp(4,timestamp);

            ps.executeUpdate();
//            while (rs.next()){
//                System.out.println("姓名--"+rs.getString(1)+"----->密码--"
//                +rs.getString(2));
//            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    }
}
