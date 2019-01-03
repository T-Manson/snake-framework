package snake.framework.test.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import snake.framework.common.util.HttpUtil;
import snake.framework.test.api.model.SearchWeatherRequest;
import snake.framework.test.api.model.weather.WeatherResponse;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author TManson
 */
@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("search-weather")
    private WeatherResponse searchWeather(@RequestBody SearchWeatherRequest request) {
        try {
            return HttpUtil.get(MessageFormat.format("http://t.weather.sojson.com/api/weather/city/{0}", request.getCityId()),
                    WeatherResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
