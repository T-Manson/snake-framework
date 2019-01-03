package snake.framework.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author TManson
 */
public final class StringUtil {

    /**
     * 大写正则
     */
    private static final Pattern UPPER_CASE_PATTERN = Pattern.compile("[A-Z]");

    private StringUtil() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 判断字符串是否为空或者空白字符串
     *
     * @param str 字符串
     * @return
     */
    public static boolean isNullOrWhiteSpace(String str) {
        if (isNullOrEmpty(str)) {
            return true;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 比较是否相等
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }
        return str1.equals(str2);
    }

    /**
     * 忽略大小写比较是否相等
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return
     */
    public static boolean ignoreCaseEquals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equalsIgnoreCase(str2);
    }

    /**
     * 转小写
     *
     * @param str 字符串
     * @return 全小写的字符串
     */
    public static String toLowerCase(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return str.toLowerCase();
    }

    /**
     * 转大写
     *
     * @param str 字符串
     * @return 全大写的字符串
     */
    public static String toUpperCase(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return str.toUpperCase();
    }

    /**
     * 将字符串集合根据指定分隔符转换为字符串
     *
     * @param source    字符串集合
     * @param separator 分隔符
     * @return 指定分隔符分隔的字符串
     */
    public static String join(Iterable<String> source, String separator) {
        if (source == null) {
            return null;
        }

        if (separator == null || separator.isEmpty()) {
            separator = ",";
        }

        return String.join(separator, source);
    }

    /**
     * Pascal命名转换为小写下划线分割
     *
     * @param str 字符串
     * @return 小写下划线分割格式的字符串
     */
    public static String convertPascalToUnderline(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }

        StringBuilder builder = new StringBuilder(str);
        Matcher mc = UPPER_CASE_PATTERN.matcher(str);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        char underline = '_';
        if (underline == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }

        return builder.toString();
    }
}
