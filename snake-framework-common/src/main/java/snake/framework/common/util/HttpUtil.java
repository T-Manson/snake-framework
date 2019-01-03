package snake.framework.common.util;

import com.alibaba.fastjson.TypeReference;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Http工具类
 *
 * @author TManson
 */
public final class HttpUtil {

    /**
     * 默认正文类型
     */
    public static final String DEFAULT_CONTENT_TYPE = "application/json";

    /**
     * 未找到源头IP时使用
     */
    private static final String UNKNOWN = "unknown";

    /**
     * HTTP客户端
     */
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    private HttpUtil() {
    }

    /**
     * 获取HTTP客户端对象
     *
     * @return HTTP客户端对象
     */
    public static HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * get请求
     *
     * @param uri         资源地址
     * @param targetClass 返回类型
     * @param <T>
     * @return
     */
    public static <T> T get(String uri, Class<T> targetClass)
            throws IOException, InterruptedException {
        return JsonUtil.jsonToObject(targetClass, get(uri));
    }

    /**
     * get请求
     *
     * @param uri         资源地址
     * @param targetClass 返回类型
     * @param <T>
     * @return
     */
    public static <T> T get(String uri, TypeReference<T> targetClass)
            throws IOException, InterruptedException {
        return JsonUtil.jsonToObject(targetClass, get(uri));
    }

    /**
     * post请求
     *
     * @param uri         资源地址
     * @param contentType 正文类型
     * @param body        请求体
     * @param targetClass 返回类型
     * @param <T>         返回类型
     * @return
     */
    public static <T> T post(String uri, String contentType, String body, Class<T> targetClass)
            throws IOException, InterruptedException {
        return JsonUtil.jsonToObject(targetClass, post(uri, contentType, body));
    }

    /**
     * post请求
     *
     * @param uri         资源地址
     * @param contentType 正文类型
     * @param body        请求体
     * @param targetClass 返回类型
     * @param <T>         返回类型
     * @param <U>         请求体类型
     * @return
     */
    public static <T, U> T post(String uri, String contentType, U body, Class<T> targetClass)
            throws IOException, InterruptedException {
        return JsonUtil.jsonToObject(targetClass,
                post(uri, contentType, JsonUtil.valueToJson(body, false)));
    }

    /**
     * post请求
     *
     * @param uri          资源地址
     * @param contentType  请求头
     * @param body         请求体
     * @param responseType 返回类型
     * @param <T>          返回类型
     * @param <U>          请求体类型
     * @return
     */
    public static <T, U> T post(String uri, String contentType, U body, TypeReference<T> responseType)
            throws IOException, InterruptedException {
        return JsonUtil.jsonToObject(responseType,
                post(uri, contentType, JsonUtil.valueToJson(body, false)));
    }

    /**
     * 获取调用方真实IP
     *
     * @param request 请求对象
     * @return
     */
    public static String getRemoteIPAddress(HttpServletRequest request) {
        String ip = null;

        // X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses == null || ipAddresses.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            // Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            // WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            // HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            // X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        // 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        // 还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取当前服务器IP
     *
     * @return 当前服务器IP
     */
    public static String getCurrentIPAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "";
        }
    }

    /**
     * 获取请求Body
     *
     * @param request 请求对象
     * @return
     * @throws IOException
     */
    public static String getRequestBody(HttpServletRequest request) throws IOException {
        ServletInputStream servletInputStream = request.getInputStream();
        StringBuilder content = new StringBuilder();
        byte[] byteArray = new byte[request.getContentLength()];
        int lens;
        while ((lens = servletInputStream.read(byteArray)) > 0) {
            content.append(new String(byteArray, 0, lens));
        }
        return content.toString();
    }

    /**
     * 是否是HTTP请求地址（HTTP/HTTPS）
     *
     * @param url 请求地址
     * @return
     */
    public static boolean isHttpUrl(String url) {
        return !StringUtil.isNullOrWhiteSpace(url)
                && (url.indexOf("http://") == 0 || url.indexOf("https://") == 0);
    }

    /**
     * 执行GET请求
     *
     * @param uri 资源地址
     * @return 响应体
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    private static String get(String uri) throws IOException, InterruptedException {
        if (StringUtil.isNullOrWhiteSpace(uri)) {
            return null;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    /**
     * 执行POST请求
     *
     * @param uri         资源地址
     * @param contentType 正文类型
     * @param body        请求体
     * @return 响应体
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    private static String post(String uri, String contentType, String body)
            throws IOException, InterruptedException {
        if (StringUtil.isNullOrWhiteSpace(uri)) {
            return null;
        }

        if (StringUtil.isNullOrWhiteSpace(contentType)) {
            contentType = DEFAULT_CONTENT_TYPE;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", contentType)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(uri))
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}