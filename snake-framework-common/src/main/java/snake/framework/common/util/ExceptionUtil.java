package snake.framework.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

/**
 * 异常工具类
 *
 * @author TManson
 */
public final class ExceptionUtil {

    /**
     * 异常信息模板
     */
    private static final String MESSAGE_FORMAT = "错误来源类名：{0}，错误来源方法名：{1}，异常信息：{2}";

    private ExceptionUtil() {
    }

    /**
     * 获取完整的异常堆栈信息
     *
     * @param throwable Exception
     * @return Full StackTrace
     */
    public static String getStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        }

        try (StringWriter sw = new StringWriter()) {
            try (PrintWriter pw = new PrintWriter(sw)) {
                throwable.printStackTrace(pw);
                pw.flush();
            }

            sw.flush();
            return sw.toString();
        } catch (IOException ex) {
            return "";
        }
    }

    /**
     * 获取异常信息
     *
     * @param throwable Exception
     * @return 异常信息
     */
    public static String getMessage(Throwable throwable) {
        if (throwable == null) {
            return null;
        }

        String className = throwable.getStackTrace()[0].getClassName();
        String methodName = throwable.getStackTrace()[0].getMethodName();
        return throwable.getCause() == null
                ? MessageFormat.format(MESSAGE_FORMAT, className, methodName, throwable.toString())
                : MessageFormat.format(MESSAGE_FORMAT, className, methodName, throwable.getCause().toString());
    }
}
