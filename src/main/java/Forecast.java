import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast  {

    private String date;
    private long dateTs;
    private PartsOfWeather parts;

    public PartsOfWeather getParts() {
        return parts;
    }

    public void setParts(PartsOfWeather parts) {
        this.parts = parts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDateTs() {
        return dateTs;
    }

    @JsonSetter("date_ts")
    public void setDateTs(long date_ts) {
        this.dateTs = date_ts;
    }

}
