import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualWeather extends InfoWeather {

    private double temp;
    private String season;
    private double obsTime;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getObs_time() {
        return obsTime;
    }

    public void setObs_time(double obsTime) {
        this.obsTime = obsTime;
    }
}
