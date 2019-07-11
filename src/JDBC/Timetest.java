package JDBC;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转long   long转时间
 * Date  yy-MM-dd
 * Time hh:mm:ss
 * Timestamp yy-MM-dd hh:mm:ss
 */
public class Timetest {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            Long time = format.parse("2019-5-6 10:10:10").getTime();

            Timestamp date = new Timestamp(time);

            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
