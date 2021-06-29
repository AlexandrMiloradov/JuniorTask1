import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private int now;

    private String nowDt;
    private InfoPlace info;
    private List<Forecast> forecasts = new ArrayList<>();
    private final static String nameApiKey = "X-Yandex-API-Key";
    private final static String apiKey = "49217bed-5aca-4739-95fe-0e04feb2fc90";
    private final static String url = "https://api.weather.yandex.ru/v2/forecast?";
    private double tempAvg = 10;
    private short days;
    private boolean extra;

    public Weather(){

    }

    public Weather(InfoPlace infoPlace){
        info = infoPlace;
    }

    public Weather(double lat, double lon, boolean extra, short days) throws IOException {
        this.days = days;
        this.extra = extra;
        this.info = new InfoPlace(lat, lon);
    }

    public String getNameApiKey() {
        return nameApiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUrl() {
        return url;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public short getDays() {
        return days;
    }

    public void setDays(short days) {
        this.days = days;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    @JsonGetter("nowDt")
    public String getNowDt() {
        return nowDt;
    }

    @JsonSetter("now_dt")
    public void setNowDt(String nowDt) {
        this.nowDt = nowDt;
    }

    public InfoPlace getInfo() {
        return info;
    }

    public void setInfo(InfoPlace info) {
        this.info = info;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    private void setTempAvg(){
        int i = 0;
        double temp_avg = 0;
        for (i = 0; i < forecasts.size(); i ++) {
            InfoWeather day_forecast = forecasts.get(i).getParts().getDay();
            temp_avg += day_forecast.getTempAvg();
            i++;
        }
        if (i!=0){
            this.tempAvg = temp_avg/i;
        }
    }

    public void getWeatherFromApi() throws IOException, APIYandexExceptions {
        UrlConnector urlConnector = new UrlConnector(getUrlStringForApiRequest());
        urlConnector.openConnection();
        urlConnector.setTheHeadersToUrl(getNameApiKey(), getApiKey());
        StringReader stringReader = urlConnector.getAnswerFromUrl();
        getWeatherFromJsonString(stringReader);
    }

    public void getWeatherFromJsonString(StringReader stringReader) throws IOException {
        ObjectMapper jmap = new ObjectMapper();
        Weather weather = jmap.readValue(stringReader, Weather.class);
        this.now = weather.now;
        this.nowDt = weather.nowDt;
        this.info = weather.info;
        this.forecasts = weather.forecasts;
        weather = null;
    }

    public static void writeRequest(Weather weather, String catalog) throws IOException {
        final char dm = (char) 34;
        String jsonString;
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonString = jsonMapper.writeValueAsString(weather)+",";
        jsonString = jsonString.substring(0, jsonString.length()-1) + "]}";
        FileWriter fileWriter = new FileWriter(catalog);
        fileWriter.write(jsonString);
        fileWriter.close();
    }

    public String getUrlStringForApiRequest(){

        String urlRequest = url + "lat=%s&lon=%s&limit=%s";

        urlRequest = String.format(urlRequest, info.getLat(), info.getLon(), days);

        return urlRequest;
    }

}
