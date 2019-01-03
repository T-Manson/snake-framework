package snake.framework.common.test.model.weather;

import lombok.Data;

import java.util.Date;

@Data
public class WeatherResponse {
    private Date time;
    private String date;
    private String message;
    private Integer status;
    private CityInfo cityInfo;
    private DataInfo data;
}
