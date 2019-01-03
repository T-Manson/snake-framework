package snake.framework.test.api.model.weather;

import lombok.Data;

import java.util.List;

/**
 * @author TManson
 */
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
