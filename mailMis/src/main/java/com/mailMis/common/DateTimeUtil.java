package com.mailMis.common;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ArnoldLee on 17/9/28.
 */
public class DateTimeUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";

    private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT_NORMAL);

    /**
     * 获取当前时间到毫秒
     *
     * @Title:getCurrentMinisecond
     * @Description:
     * @Param:@return
     * @Return:String
     * @throws
     * @Date:2016年3月1日
     */
    public static String getCurrentMinisecond() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(new Date());
    }

    /**
     * 获取当前系统日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 将毫秒转换为日期格式
     *
     * @param millis
     *            毫秒
     * @return
     */
    public static String getStringTimeByMillis(Long millis) {
        if (null != millis) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);
            return formatter.format(calendar.getTime());
        }
        return "";
    }

    /**
     *
     * @Title: isValidDate 验证日期字符串格式是否为yyyy-MM-dd
     * @Description: 验证日期字符串格式是否为yyyy-MM-dd
     * @param @param str
     * @param @return
     * @return boolean 返回类型 格式验证通过返回true,否则返回false
     * @throws
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 将日期格式化成指定的格式
     *
     * @param format
     * @param date
     * @return
     */
    public static final String getDate2String(String format, Date date) {
        if (date != null) {
            if (StringUtils.isEmpty(format)) {
                format = YYYY_MM_DD_HH_MM_SS;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

            return simpleDateFormat.format(date);
        } else {
            return "";
        }
    }

    /**
     * 比较2个日期大小
     *
     * @param d1
     * @param d2
     * @return return 前者大于等于后者返回true 反之false
     */
    public static boolean compareDate(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        int result = c1.compareTo(c2);
        if (result >= 0)
            return true;
        else
            return false;
    }

    /**
     * 比较2个日期大小
     *
     * @param d1
     * @param d2
     * @return return 0:二者相等,1:前者大于后者，-1前者小于后者
     */
    public static int compareDateStrict(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        int result = c1.compareTo(c2);
        if (result == 0) {
            result = 0;
        } else if (result > 0) {
            result = 1;
        } else if (result < 0) {
            result = -1;
        }

        return result;
    }

    /**
     * @Title: getDateMinusDays
     * @Description: 返回（日期-days）对应的日期
     * @param date
     *            日期
     * @param days
     *            天数
     * @param @return
     * @return Date
     * @throws
     */
    public static Date getDateMinusDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -days);
        return calendar.getTime();
    }

    /**
     * 将字符串的日志转化为date类型的
     *
     * @param origin
     * @return
     */
    public static Date convertString2Date(String origin) {
        try {
            return SDF.parse(origin);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date or Time String is invalid.");
        }
    }

    /**
     * DateUtil.str2DateTime方法改进，判断""的字符串进行格式化
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
//    public static Date str2DateTime(String dateStr, String pattern) throws ParseException {
//        if (ComUtil.isBlank(dateStr)) {
//            return null;
//        }
//        return DateUtil.str2DateTime(dateStr, pattern);
//    }

    /**
     * 把指定日期转换成yyyy-mm-dd 23:59:59形式
     * @param date
     * @return
     */
    public static Date formateTo235959(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

}
