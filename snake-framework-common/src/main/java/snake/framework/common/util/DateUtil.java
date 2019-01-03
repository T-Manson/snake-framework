package snake.framework.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author TManson
 */
public final class DateUtil {

    /**
     * 区域ID
     */
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    /**
     * 日期格式转换
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private DateUtil() {
    }

    /**
     * 转换日期（默认当前时区）
     *
     * @param date 日期
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_ZONE_ID);
    }

    /**
     * 转换日期
     *
     * @param date   日期
     * @param zoneId 时区Id
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     */
    public static String format(Date date, ZoneId zoneId) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), zoneId).format(DATE_TIME_FORMATTER);
    }
}
