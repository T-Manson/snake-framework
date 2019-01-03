package snake.framework.common.util;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 转换类型工具类
 *
 * @author TManson
 * @date 2018/06/13
 */
public final class ConvertUtil {

    private ConvertUtil() {
    }

    /**
     * 转换类型
     *
     * @param value       值
     * @param targetClass 目标
     * @param <T>         目标类型（基本类型）
     * @return 目标值
     */
    public static <T> T change(String value, Class<T> targetClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (targetClass == null) {
            return null;
        }

        if (String.class.getTypeName().equals(targetClass.getTypeName())) {
            return (T) value;
        }

        return StringUtil.isNullOrWhiteSpace(value)
                ? targetClass.getDeclaredConstructor().newInstance()
                : (T) ConvertUtils.convert(value, targetClass);
    }
}
