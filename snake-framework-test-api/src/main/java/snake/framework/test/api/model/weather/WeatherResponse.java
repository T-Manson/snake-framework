package snake.framework.test.api.model.weather;

import lombok.Data;

import java.util.Date;

/**
 * @author TManson
 */
@Data
public class WeatherResponse {
    private Date time;
    private String date;
    private String message;
    private Integer status;
    private CityInfo cityInfo;
    private DataInfo data;
}
