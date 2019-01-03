package snake.framework.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON工具类
 *
 * @author TManson
 */
public final class JsonUtil {

    static {
        // 使用序列化的Json中的类型自动类型转换
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    private JsonUtil() {
    }

    /**
     * 值转Json
     *
     * @param value            值
     * @param isWriteClassName 是否写入完整类名信息
     * @param <T>              值的类型
     * @return Json字符串
     */
    public static <T> String valueToJson(T value, boolean isWriteClassName) {
        return isWriteClassName
                ? JSON.toJSONString(value, SerializerFeature.WriteClassName)
                : JSON.toJSONString(value);
    }

    /**
     * Json转对象
     *
     * @param targetClass 结果类型
     * @param json        Json字符串
     * @param <T>         结果类型
     * @return 结果类型对象
     */
    public static <T> T jsonToObject(Class<T> targetClass, String json) {
        return JSON.parseObject(json, targetClass);
    }

    /**
     * Json转对象
     *
     * @param typeReference 结果类型引用
     * @param json          Json字符串
     * @param <T>           结果类型
     * @return 结果类型对象
     */
    public static <T> T jsonToObject(TypeReference<T> typeReference, String json) {
        return JSON.parseObject(json, typeReference);
    }
}
