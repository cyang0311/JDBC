package JDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class select06 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long time = null;


        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                time = format.parse("2019-05-07").getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }


            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01",
                        "root","123456");

                conn.setAutoCommit(false);
                String sql = "select id,regtime from user where regtime>?";
                ps = conn.prepareStatement(sql);
                ps.setDate(1,new Date(time));

                rs = ps.executeQuery();
                conn.commit();
                while (rs.next()){
                    System.out.println("ID:  "+rs.getString(1)+"   -----  时间："+rs.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
