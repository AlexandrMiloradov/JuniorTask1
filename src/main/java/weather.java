import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class weather {

    private int now;
    private String now_dt;
    private infoPlace info;
    private factWeather fact;
    private List<forecast> forecasts = new ArrayList<>();
    private static String apiKey = "49217bed-5aca-4739-95fe-0e04feb2fc90";
    private static String url = "https://api.weather.yandex.ru/v2/forecast?";
    private double temp_avg;
    private short days;

    public weather(){

    }

    public weather(double lat, double lon, boolean extra, short days) throws IOException {

        this.days = days;
        String urlRequest = weather.url+"lat="+lat+"&"+"lon="+lon+"&"+"extra="+Boolean.toString(extra)+"&"+"limit="+days;
        final URL url = new URL(urlRequest);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Yandex-API-Key", weather.apiKey);
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                StringReader stringReader = new StringReader(inputLine);
                ObjectMapper jmap = new ObjectMapper();
                weather weather = jmap.readValue(stringReader, weather.class);
                this.now = weather.now;
                this.fact = weather.fact;
                this.forecasts = weather.forecasts;
                this.info = weather.info;
                this.now_dt = weather.now_dt;
                weather = null;
                setTemp_avg();
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    public double getTemp_avg() {
        return temp_avg;
    }

    public void setTemp_avg(double temp_avg) {
        this.temp_avg = temp_avg;
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

    public String getNow_dt() {
        return now_dt;
    }

    public void setNow_dt(String now_dt) {
        this.now_dt = now_dt;
    }

    public infoPlace getInfo() {
        return info;
    }

    public void setInfo(infoPlace info) {
        this.info = info;
    }

    public factWeather getFact() {
        return fact;
    }

    public void setFact(factWeather fact) {
        this.fact = fact;
    }

    public List<forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<forecast> forecasts) {
        this.forecasts = forecasts;
    }

    private void setTemp_avg(){
        int i = 0;
        double temp_avg = 0;
        for (forecast forecast:forecasts) {
           infoWeather day_forecast = forecast.getParts().getDay();
           temp_avg = temp_avg+day_forecast.getTemp_avg();
           i++;
        }
        if (i!=0){
            this.temp_avg = temp_avg/i;
        }
    }
    public static void writeRequest(List<weather> weatherObjects, String catalog) throws IOException {
        final char dm = (char) 34;
        String jsonString = "{"+dm+"cities"+dm+":[";
        ObjectMapper jsonMapper = new ObjectMapper();
        for (weather weather:weatherObjects) {
            jsonString = jsonString + jsonMapper.writeValueAsString(weather)+",";
        }
        jsonString = jsonString.substring(0, jsonString.length()-1) + "]}";
        FileWriter fileWriter = new FileWriter(catalog);
        fileWriter.write(jsonString);
        fileWriter.close();
    }
}
