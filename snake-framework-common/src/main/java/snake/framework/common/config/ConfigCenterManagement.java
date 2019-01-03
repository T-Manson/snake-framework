package snake.framework.common.config;

import org.springframework.core.env.Environment;
import snake.framework.common.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置中心管理
 *
 * @author zhanglonglong
 * @date 2018/6/5
 */
public final class ConfigCenterManagement {

    /**
     * 是否初始化
     */
    private static boolean inited = false;

    /**
     * 配置中心所有配置
     */
    private static Map<String, Object> properties;

    private ConfigCenterManagement() {
    }

    /**
     * 初始化配置
     *
     * @param environment 环境
     */
    public static synchronized void initializeConfiguration(Environment environment) {
        // 加载本地配置文件中定义的配置
        try {
            // ResourceUtil.setEnvironment(environment);

            // 将配置中心定义的配置合并至本地
            ConfigCenterBean configCenterBean = new ConfigCenterBean(environment.getProperty("config.appname"),
                    environment.getProperty("config.configcenteraddress"));

            initializeConfiguration(configCenterBean);
        } catch (Exception ex) {
            // ConsoleLogger.error(ex);
        }
    }

    /**
     * 获取配置中心所有配置
     *
     * @return
     */
    public static synchronized Map<String, Object> getProperties() {
        if (inited && (properties == null || properties.isEmpty())) {
            Map<String, String> configs = null;// ConfigClient.getConfig().getConfigs();
            properties = new HashMap<>(configs.size());
            for (Map.Entry<String, String> entry : configs.entrySet()) {
                properties.put(entry.getKey().toLowerCase(), entry.getValue());
            }
        }
        return properties;
    }

    /**
     * 初始化配置中心
     *
     * @param configCenterBean 配置中心配置
     * @throws Exception 异常
     */
    private static void initializeConfiguration(ConfigCenterBean configCenterBean) throws Exception {
        if (!inited && configCenterBean != null
                && !StringUtil.isNullOrEmpty(configCenterBean.getAppName())
                && !StringUtil.isNullOrEmpty(configCenterBean.getConfigCenterAddress())) {
//            ConfigClient.run(c -> {
//                c.setAppName(configCenterBean.getAppName());
//                c.setConfigCenterAddress(configCenterBean.getConfigCenterAddress());
//            });
//            inited = true;
//            ConsoleLogger.info("Successfully load yiguo config center configuration");
        }
    }
}
