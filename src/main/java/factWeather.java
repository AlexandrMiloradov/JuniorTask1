import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class factWeather extends infoWeather {

    private double temp;
    private String season;
    private double obs_time;
    private String phenom_icon;
    private String phenom_condition;

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

    public String getPhenom_icon() {
        return phenom_icon;
    }

    public void setPhenom_icon(String phenom_icon) {
        this.phenom_icon = phenom_icon;
    }

    public String getPhenom_condition() {
        return phenom_condition;
    }

    public void setPhenom_condition(String phenom_condition) {
        this.phenom_condition = phenom_condition;
    }
}
