import com.hu.hy.util.DateUtil;

import java.util.Date;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) DateTest.java 2017/03/27 10:24
 */
public class DateTest {

    public static void main(String[] args) {
        String formatStr="yyyy-MM-dd HH:mm:ss sss a";
        int year=2017;
        int month=2;
        long monthStart = DateUtil.getMonthStart(year, month);
        String start = DateUtil.getDateStringByFormat(monthStart,formatStr );
        System.out.println("start:"+start);
        long monthEnd = DateUtil.getMonthEnd(year, month);
        String end = DateUtil.getDateStringByFormat(monthEnd,formatStr);
        System.out.println("end:"+end);
    }
}