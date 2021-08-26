import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartsOfWeather {

    private InfoWeather day;

    public InfoWeather getDay() {
        return day;
    }

    public void setDay(InfoWeather day) {
        this.day = day;
    }
}
