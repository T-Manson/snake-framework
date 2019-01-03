package snake.framework.common.test;

import com.alibaba.fastjson.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import snake.framework.common.test.model.SearchWeatherRequest;
import snake.framework.common.test.model.weather.WeatherResponse;
import snake.framework.common.util.HttpUtil;

import java.io.IOException;

public class CommonTests {

    @Test
    void weatherGetClassTest() {
        try {
            WeatherResponse weatherResponse = HttpUtil.get("http://t.weather.sojson.com/api/weather/city/101030100", WeatherResponse.class);
            System.out.println(weatherResponse);
            Assertions.assertTrue(weatherResponse != null
                    && weatherResponse.getData() != null
                    && weatherResponse.getData().getForecast() != null
                    && weatherResponse.getCityInfo() != null
                    && weatherResponse.getCityInfo().getCityId().equals("101030100"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void weatherGetTypeReferenceTest() {
        try {
            WeatherResponse weatherResponse = HttpUtil.get("http://t.weather.sojson.com/api/weather/city/101030100",
                    new TypeReference<>() {
                    });
            System.out.println(weatherResponse);
            Assertions.assertTrue(weatherResponse != null
                    && weatherResponse.getData() != null
                    && weatherResponse.getData().getForecast() != null
                    && weatherResponse.getCityInfo() != null
                    && weatherResponse.getCityInfo().getCityId().equals("101030100"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void weatherPostClassTest() {
        try {
            SearchWeatherRequest request = new SearchWeatherRequest();
            request.setCityId("101030100");
            WeatherResponse weatherResponse = HttpUtil.post("http://localhost:8970/test/search-weather",
                    HttpUtil.DEFAULT_CONTENT_TYPE, request, WeatherResponse.class);
            System.out.println(weatherResponse);
            Assertions.assertTrue(weatherResponse != null
                    && weatherResponse.getData() != null
                    && weatherResponse.getData().getForecast() != null
                    && weatherResponse.getCityInfo() != null
                    && weatherResponse.getCityInfo().getCityId().equals("101030100"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void weatherPostTypeReferenceTest() {
        try {
            SearchWeatherRequest request = new SearchWeatherRequest();
            request.setCityId("101030100");
            WeatherResponse weatherResponse = HttpUtil.post("http://localhost:8970/test/search-weather",
                    HttpUtil.DEFAULT_CONTENT_TYPE, request, new TypeReference<>() {
                    });
            System.out.println(weatherResponse);
            Assertions.assertTrue(weatherResponse != null
                    && weatherResponse.getData() != null
                    && weatherResponse.getData().getForecast() != null
                    && weatherResponse.getCityInfo() != null
                    && weatherResponse.getCityInfo().getCityId().equals("101030100"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
