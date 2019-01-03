package snake.framework.common.util;

import java.util.List;

/**
 * 守护工具类
 *
 * @author TManson
 */
public final class GuardUtil {

    private GuardUtil() {
    }

    /**
     * 判断参数集合是否为空，为空则抛出异常
     *
     * @param list         集合
     * @param argumentName 参数名称
     * @param <T>          集合类型
     */
    public static <T> void argumentNullOrEmptyList(List<T> list, String argumentName) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(String.format("集合 %s 不能为空。", argumentName));
        }
    }

    /**
     * 判断参数集合是否为空，为空则抛出异常
     *
     * @param list      集合
     * @param msgFormat 消息模板
     * @param msg       消息内容
     * @param <T>       集合类型
     */
    public static <T> void argumentNullOrEmptyList(List<T> list, String msgFormat, String msg) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(String.format(msgFormat, msg));
        }
    }

    /**
     * 判断参数是否为空或空字符，为空或空字符则抛出异常
     *
     * @param argumentValue 参数值
     * @param argumentName  参数名
     */
    public static void argumentNullOrWhiteSpaceString(String argumentValue, String argumentName) {
        argumentNotNullOrEmptyString(argumentValue, argumentName, true);
    }

    /**
     * 判断参数是否为空，为空则抛出异常
     *
     * @param argumentValue 参数值
     * @param argumentName  参数名
     */
    public static void argumentNotNullOrEmptyString(String argumentValue, String argumentName) {
        argumentNotNullOrEmptyString(argumentValue, argumentName, false);
    }

    /**
     * 判断参数是否为null，为null则抛出异常
     *
     * @param argumentValue 参数值
     * @param argumentName  参数名
     */
    public static void argumentNotNull(Object argumentValue, String argumentName) {
        if (argumentValue == null) {
            throw new IllegalArgumentException(String.format("参数 %s 不能为空。", argumentName));
        }
    }

    /**
     * 判断参数是否为null，为null则抛出异常
     *
     * @param argumentValue 参数值
     * @param msgFormat     消息模板
     * @param msg           消息内容
     */
    public static void argumentNotNull(Object argumentValue, String msgFormat, String msg) {
        if (argumentValue == null) {
            throw new IllegalArgumentException(String.format(msgFormat, msg));
        }
    }

    /**
     * 数值是否在秒的区间范围，超出范围则抛出异常
     *
     * @param data         数值
     * @param argumentName 参数名
     */
    public static void inSecondRange(int data, String argumentName) {
        if (data > 59 || data < 0) {
            throw new IllegalArgumentException(String.format("参数 %s 表示秒数，取值必须在 0 - 59 之间。", argumentName));
        }
    }

    /**
     * 数值是否在分钟的区间范围，超出范围则抛出异常
     *
     * @param data         数值
     * @param argumentName 参数名
     */
    public static void inMinuteRange(int data, String argumentName) {
        if (data > 59 || data < 0) {
            throw new IllegalArgumentException(String.format("参数 %s 表示分钟，取值必须在 0 - 59 之间。", argumentName));
        }
    }

    /**
     * 数值是否小时的区间范围，超出范围则抛出异常
     *
     * @param data         数值
     * @param argumentName 参数名
     */
    public static void inHourRange(int data, String argumentName) {
        if (data > 23 || data < 0) {
            throw new IllegalArgumentException(String.format("参数 %s 表示小时，取值必须在 0 - 59 之间。", argumentName));
        }
    }

    /**
     * 数值是否在日的区间范围，超出范围则抛出异常
     *
     * @param data         数值
     * @param argumentName 参数名
     */
    public static void inMonthDayRange(int data, String argumentName) {
        if (data > 31 || data < 1) {
            throw new IllegalArgumentException(String.format("参数 %s 表示每月的日期，取值必须在 1 - 31 之间。", argumentName));
        }
    }

    /**
     * 数值是否在月的区间范围，超出范围则抛出异常
     *
     * @param data         数值
     * @param argumentName 参数名
     */
    public static void inMonthRange(int data, String argumentName) {
        if (data > 12 || data < 1) {
            throw new IllegalArgumentException(String.format("参数 %s 表示月份，取值必须在 1 - 12 之间。", argumentName));
        }
    }

    /**
     * 判断参数是否为空，为空则抛出异常
     *
     * @param argumentValue 参数值
     * @param argumentName  参数名
     * @param trimString    是否判断空字符
     */
    private static void argumentNotNullOrEmptyString(String argumentValue, String argumentName, boolean trimString) {
        if (trimString && StringUtil.isNullOrWhiteSpace(argumentValue)) {
            throw new IllegalArgumentException(String.format("参数 %s 不能为空或空串。", argumentName));
        }

        if (!trimString && StringUtil.isNullOrEmpty(argumentValue)) {
            throw new IllegalArgumentException(String.format("参数 %s 不能为空或空串。", argumentName));
        }
    }
}
