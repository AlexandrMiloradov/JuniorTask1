import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualWeather extends InfoWeather {

    private double temp;
    private String season;
    private double obs_time;

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
        return obs_time;
    }

    public void setObs_time(double obs_time) {
        this.obs_time = obs_time;
    }
}
