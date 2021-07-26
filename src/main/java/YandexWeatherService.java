import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class YandexWeatherService {

    private final static String nameApiKey = "X-Yandex-API-Key";
    private final static String apiKey = "db6702a8-84a2-4bf0-89f4-445912306ab1"; //0
    private final static String url = "https://api.weather.yandex.ru/v2/forecast?";

    private static Weather getWeatherFromJsonString(StringReader stringReader) throws IOException {

        Weather weather = new Weather();

        ObjectMapper jmap = new ObjectMapper();
        weather = jmap.readValue(stringReader, new TypeReference<Weather>() {
        });
        return weather;
    }

    public static Weather getWeatherForPlace(FilterYandexWeatherData filterYandexWeatherData) throws IOException, APIYandexExceptions {

        UrlConnector urlConnector = new UrlConnector(url);

        Map<String, String> params = new LinkedHashMap<>();
        params.put("lat", Double.toString(filterYandexWeatherData.getLat()));
        params.put("lon", Double.toString(filterYandexWeatherData.getLon()));
        params.put("limit", Short.toString(filterYandexWeatherData.getDays()));

        Map<String, String> headers = new LinkedHashMap<>();
        headers.put(nameApiKey, apiKey);

        RequestData requestData = new RequestData(headers, params);

        StringReader stringAnswer = null;
        Weather weather = null;
        try{
            stringAnswer = urlConnector.sendRequest(requestData);
        }
        catch (APIYandexExceptions ex){
            System.out.println(ex.getMessage());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        try{
            weather = getWeatherFromJsonString(stringAnswer);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return weather;
    }
}
