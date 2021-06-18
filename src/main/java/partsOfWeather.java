import com.fasterxml.jackson.annotation.*;

public class partsOfWeather {
    @JsonIgnore
    private infoWeather night;
    @JsonIgnore
    private infoWeather morning;
    private infoWeather day;
    @JsonIgnore
    private infoWeather evening;
    @JsonIgnore
    private infoWeather day_short;
    @JsonIgnore
    private infoWeather night_short;

    public infoWeather getNight() {
        return night;
    }

    public void setNight(infoWeather night) {
        this.night = night;
    }

    public infoWeather getMorning() {
        return morning;
    }

    public void setMorning(infoWeather morning) {
        this.morning = morning;
    }

    public infoWeather getDay() {
        return day;
    }

    public void setDay(infoWeather day) {
        this.day = day;
    }

    public infoWeather getEvening() {
        return evening;
    }

    public void setEvening(infoWeather evening) {
        this.evening = evening;
    }

    public infoWeather getDay_short() {
        return day_short;
    }

    public void setDay_short(infoWeather day_short) {
        this.day_short = day_short;
    }

    public infoWeather getNight_short() {
        return night_short;
    }

    public void setNight_short(infoWeather night_short) {
        this.night_short = night_short;
    }
}
