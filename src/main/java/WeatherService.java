import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class WeatherService {

    public static void setTempAvg(Weather weather){

        int i = 0;
        double temp_avg = 0;
        List<Forecast> forecasts = weather.getForecasts();
        for (i = 0; i < forecasts.size(); i ++) {
            InfoWeather day_forecast = forecasts.get(i).getParts().getDay();
            temp_avg += day_forecast.getTempAvg();
            i++;
        }
        if (i!=0){
            weather.setTempAvg(temp_avg/i);
        }

    }

    public static void writeRequest(Weather weather, String catalog) throws IOException {
        FileWriter fileWriter = new FileWriter(catalog);
        try{
            String jsonString;
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonString = jsonMapper.writeValueAsString(weather);
            fileWriter.write(jsonString);
            StringReader stringReader = new StringReader("");
        } catch (FileNotFoundException | FileAlreadyExistsException ex){
            ex.getMessage();
        } finally {
            fileWriter.close();
        }
    }
}
