package JDBC;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 大文本对象clob  流模式将整个文件内容存入数据库
 */
public class Clob {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","123456");
            String sql = "insert into user (name,info) values (?,?)";
            String sql2 = "select info from user where id = 4070";

            //写入CLOB
//            ps = conn.prepareStatement(sql);
//            ps.setObject(1,"aaa");
//            ps.setClob(2,new FileReader(new File("f:/a.txt")));
//            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaa".getBytes()))));


            //读出clob
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();

            while (rs.next()){
                java.sql.Clob c = rs.getClob("info");
                Reader r = c.getCharacterStream();
                int temp =0;
                while ((temp=r.read())!=-1){
                    System.out.print((char) temp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
