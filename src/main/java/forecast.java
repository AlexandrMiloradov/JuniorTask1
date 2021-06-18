import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class forecast  {

    private String date;
    private long date_ts;
    private int week;
    private String sunrise;
    private String sunset;
    private short moon_code;
    private String moon_text;
    private partsOfWeather parts;

    public partsOfWeather getParts() {
        return parts;
    }

    public void setParts(partsOfWeather parts) {
        this.parts = parts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDate_ts() {
        return date_ts;
    }

    public void setDate_ts(long date_ts) {
        this.date_ts = date_ts;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public short getMoon_code() {
        return moon_code;
    }

    public void setMoon_code(short moon_code) {
        this.moon_code = moon_code;
    }

    public String getMoon_text() {
        return moon_text;
    }

    public void setMoon_text(String moon_text) {
        this.moon_text = moon_text;
    }



}
