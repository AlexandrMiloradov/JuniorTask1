import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private int now;

    @JsonProperty("now_dt")
    private String nowDt;
    private InfoPlace info;
    private List<Forecast> forecasts = new ArrayList<>();

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

  //  @JsonGetter("nowDt")
    public String getNowDt() {
        return nowDt;
    }

  //  @JsonSetter("now_dt")
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

    public double getTempAvg() {
        return tempAvg;
    }

    public void setTempAvg(double tempAvg) {
        this.tempAvg = tempAvg;
    }
}
