import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoWeather {


    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("temp_avg")
    private double tempAvg;
    @JsonProperty("feels_like")
    private double feelsLikeTemp;
    private String condition;
    @JsonProperty("wind_speed")
    private double windSpeed;


    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    //@JsonGetter("tempMin")
    public double getTempMin() {
        return tempMin;
    }

    //@JsonSetter("temp_min")
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    //@JsonGetter("tempMax")
    public double getTempMax() {
        return tempMax;
    }

   // @JsonSetter("temp_max")
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    //@JsonGetter("tempAvg")
    public double getTempAvg() {
        return tempAvg;
    }

    //@JsonSetter("temp_avg")
    public void setTempAvg(double tempAvg) {
        this.tempAvg = tempAvg;
    }

    //@JsonGetter("feelsLikeTemp")
    public double getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

   // @JsonSetter("feels_like")
    public void setFeelsLikeTemp(double feelsLikeTemp) {
        this.feelsLikeTemp = feelsLikeTemp;
    }

    //@JsonGetter("windSpeed")
    public double getWindSpeed() {
        return windSpeed;
    }

   // @JsonSetter("wind_speed")
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
