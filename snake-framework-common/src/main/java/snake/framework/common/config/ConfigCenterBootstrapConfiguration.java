package snake.framework.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * 配置中心启动配置
 *
 * @author nifuming
 */
@Configuration
public class ConfigCenterBootstrapConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer setPropertySource(Environment environment) {
        ConfigCenterManagement.initializeConfiguration(environment);

        // 添加额外的配置中心数据源
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        ConfigurableEnvironment configurableEnvironment = ((ConfigurableEnvironment) environment);

        Map<String, Object> properties = ConfigCenterManagement.getProperties();
        if (properties != null && !properties.isEmpty()) {
            configurableEnvironment.getPropertySources().addFirst(new MapPropertySource("configCenter", properties));
        }
        propertySourcesPlaceholderConfigurer.setEnvironment(configurableEnvironment);

        return propertySourcesPlaceholderConfigurer;
    }
}