import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class start {

    public static void main(String args[]) throws IOException {
        weather weatherEkb = new weather(56.8519, 60.6122, true, (short) 3);
        weather weatherNY = new weather(40.7143, -74.006, true, (short) 3);
        weather weatherLon = new weather(51.5085, 0.12574, true, (short) 3);
        List<weather> list = Arrays.asList(weatherEkb, weatherNY,weatherLon);
        weather.writeRequest(list,"C:\\Users\\miloradov\\IdeaProjects\\MyProjectGradle\\request.json");
        System.out.println("well done !");
    }
}
