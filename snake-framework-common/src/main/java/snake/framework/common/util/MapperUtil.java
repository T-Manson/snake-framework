package snake.framework.common.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Dozer对象映射工具类
 *
 * @author TManson
 */
public final class MapperUtil {

    /**
     * Dozer Mapper对象
     */
    private static Mapper mapper = new DozerBeanMapper();

    private MapperUtil() {
    }

    /**
     * 对象映射转换
     *
     * @param source      原对象
     * @param targetClass 目标类型
     * @return 目标类型对象
     */
    public static <T> T map(Object source, Class<T> targetClass) {
        if (source == null || targetClass == null) {
            return null;
        }

        return mapper.map(source, targetClass);
    }

    /**
     * 集合对象映射转换
     *
     * @param source      对象集合
     * @param targetClass 目标类型
     * @param <T>         来源集合类型
     * @param <U>         目标集合类型
     * @return 目标类型对象集合
     */
    public static <T, U> List<U> map(Iterable<T> source, Class<U> targetClass) {
        if (source == null || targetClass == null) {
            return null;
        }

        List<U> targetList = new ArrayList<>();
        source.forEach(objectSource -> {
            if (objectSource != null) {
                U targetEntity = mapper.map(objectSource, targetClass);
                targetList.add(targetEntity);
            }
        });

        return targetList;
    }
}
