import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String args[]) throws IOException, APIYandexExceptions {
        Weather weatherEkb = new Weather(56.8519, 60.6122, true, (short) 3);
        weatherEkb.getWeatherFromApi();
        Weather weatherNY = new Weather(40.7143, -74.006, true, (short) 3);
        weatherNY.getWeatherFromApi();
        Weather weatherLon = new Weather(51.5085, 0.12574, true, (short) 3);
        weatherNY.getWeatherFromApi();
        List<Weather> list = Arrays.asList(weatherEkb, weatherNY,weatherLon);
        Weather.writeRequest(weatherEkb,"C:\\Users\\miloradov\\IdeaProjects\\MyProjectGradle\\request.json");
        System.out.println("well done !");
    }
}
