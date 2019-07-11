package JDBC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * blob二进制数据  图片等
 */
public class Blob {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","123456");
            String sql = "insert into user (name,image) values (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"ccc");
            ps.setBlob(2, new FileInputStream("f:/b.png"));

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
