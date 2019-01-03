package snake.framework.common.test.model.weather;

import lombok.Data;

@Data
public class CityInfo {
    private String city;
    private String cityId;
    private String parent;
    private String updateTime;
}
