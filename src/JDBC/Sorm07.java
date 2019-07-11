package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Object Relationship Mapping
 * 表结构和类对应  表字段和类属性对应  表记录和对象对应
 *
 * 查询结果封装   List<Object[]>
 */
public class Sorm07 {

    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<>();

        String sql = "select name,pwd,regtime from user where id>?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,0);
            rs = ps.executeQuery();

            while (rs.next()){
                Object[] obs = new Object[3];
                obs[0] = rs.getString(1);
                obs[1] = rs.getString(2);
                obs[2] = rs.getDate(3);
                list.add(obs);

                System.out.println(obs[0]+"-----"+
                        obs[1]+"----"+obs[2]);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.stop(rs,ps,conn);
        }

        System.out.println("--------------------");
        for (Object[] obj:list) {
            System.out.println(obj[0]+"-----"+
                    obj[1]+"----"+obj[2]);
        }
    }
}
