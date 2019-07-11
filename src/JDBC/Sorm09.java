package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Object Relationship Mapping
 * 表结构和类对应  表字段和类属性对应  表记录和对象对应
 *
 * 查询结果封装   Map<String,Map<String,Object>>
 */
public class Sorm09 {

    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMySQLConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Map<String,Object>> maps = new HashMap<>();

        String sql = "select name,pwd,regtime from user where id>?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,0);
            rs = ps.executeQuery();

            while (rs.next()){
                Map<String,Object> row = new HashMap<>();
                row.put("name", rs.getString(1));
                row.put("pwd",rs.getString(2));
                row.put("regtime",rs.getDate(3));

                maps.put(rs.getString(1),row);

                System.out.println(row.get("name")+"-----"+
                        row.get("pwd")+"----"+row.get("regtime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.stop(rs,ps,conn);
        }

        System.out.println("--------------------");
        for (Map map:maps.values()) {
            System.out.println(map.get("name")+"-----"+
                    map.get("pwd")+"----"+map.get("regtime"));
        }
    }
}
