package JDBC.JavaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class javaBean {
    public static void test01() {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {
            String sql = "select name,pwd from user where id>?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);

            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getString(1),rs.getString(2));
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.stop(rs,ps,conn);
        }
        for (User user:list) {
            System.out.println(user.getName()+"----"+user.getPwd());
        }
    }

    public static void main(String[] args) {
        test01();


    }
}
