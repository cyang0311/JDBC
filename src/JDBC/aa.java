package JDBC;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class aa {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;

        try {
            String sql = "select * from users where uname=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"1");
            ps.setObject(2,"1");

            rs = ps.executeQuery();

            while (rs.next()){
                u = new Users();
                u.setId(rs.getInt("id"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.stop(rs,ps,conn);
        }

        System.out.println(u.getUname()+"---"+u.getPwd()+"---"+u.getSex());
    }
}
