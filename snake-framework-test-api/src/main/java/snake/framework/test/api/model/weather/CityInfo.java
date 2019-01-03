package snake.framework.test.api.model.weather;

import lombok.Data;

/**
 * @author TManson
 */
@Data
public class CityInfo {
    private String city;
    private String cityId;
    private String parent;
    private String updateTime;
}
