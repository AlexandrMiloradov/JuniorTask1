import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class WeatherService {

    public static double getTempAvg(List<Forecast> forecasts){

        int i = 0;
        double temp_avg = 0;
        for (i = 0; i < forecasts.size(); i ++) {
            InfoWeather day_forecast = forecasts.get(i).getParts().getDay();
            temp_avg += day_forecast.getTempAvg();
            i++;
        }

        return temp_avg;
    }

    public static void writeRequest(Weather weather, String catalog) throws IOException {

        try{ FileWriter fileWriter = new FileWriter(catalog);
            String jsonString;
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonString = jsonMapper.writeValueAsString(weather);
            fileWriter.write(jsonString);
            StringReader stringReader = new StringReader("");
        } catch (FileNotFoundException | FileAlreadyExistsException ex){
            ex.getMessage();
        }
    }
}
