package snake.framework.common.test.model.weather;

import lombok.Data;

@Data
public class DayInfo {
    private String date;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    private Double aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;
}
