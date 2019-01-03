package snake.framework.common.test.model.weather;

import lombok.Data;

import java.util.List;

@Data
public class DataInfo {
    private String shidu;
    private Double pm25;
    private Double pm10;
    private String quality;
    private Integer wendu;
    private String ganmao;
    private DayInfo yesterday;
    private List<DayInfo> forecast;
}
