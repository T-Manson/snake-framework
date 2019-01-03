package snake.framework.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 配置中心配置
 *
 * @author nifuming
 * @date 2018/06/13
 */
@Data
@AllArgsConstructor
public final class ConfigCenterBean {
    /**
     * 应用名称
     */
    private String appName;

    /**
     * 配置中心地址
     */
    private String configCenterAddress;
}
