import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class infoWeather {
    private double temp_min;
    private double temp_max;
    private double temp_avg;
    @JsonIgnore
    private double temp;
    private double feels_like;
    @JsonIgnore
    private double temp_water;
    @JsonIgnore
    private String icon;
    private String condition;
    private double wind_speed;
    @JsonIgnore
    private double wind_gust;
    @JsonIgnore
    private String wind_dir;
    @JsonIgnore
    private double pressure_mm;
    @JsonIgnore
    private double pressure_pa;
    @JsonIgnore
    private double humidity;
    @JsonIgnore
    private String daytime;
    @JsonIgnore
    private boolean polar;
    @JsonIgnore
    private boolean is_thunder;
    @JsonIgnore
    private double prec_type;
    @JsonIgnore
    private double prec_strenght;
    @JsonIgnore
    private double cloudness;


    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_avg() {
        return temp_avg;
    }

    public void setTemp_avg(double temp_avg) {
        this.temp_avg = temp_avg;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_water() {
        return temp_water;
    }

    public void setTemp_water(double temp_water) {
        this.temp_water = temp_water;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public double getPressure_mm() {
        return pressure_mm;
    }

    public void setPressure_mm(double pressure_mm) {
        this.pressure_mm = pressure_mm;
    }

    public double getPressure_pa() {
        return pressure_pa;
    }

    public void setPressure_pa(double pressure_pa) {
        this.pressure_pa = pressure_pa;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    public boolean isIs_thunder() {
        return is_thunder;
    }

    public void setIs_thunder(boolean is_thunder) {
        this.is_thunder = is_thunder;
    }

    public double getPrec_type() {
        return prec_type;
    }

    public void setPrec_type(double prec_type) {
        this.prec_type = prec_type;
    }

    public double getPrec_strenght() {
        return prec_strenght;
    }

    public void setPrec_strenght(double prec_strenght) {
        this.prec_strenght = prec_strenght;
    }

    public double getCloudness() {
        return cloudness;
    }

    public void setCloudness(double cloudness) {
        this.cloudness = cloudness;
    }
}
