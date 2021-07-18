public class FilterYandexWeatherData {

    private double lat;
    private double lon;
    private short days;

    FilterYandexWeatherData(){

    }

    FilterYandexWeatherData(double lat, double lon, short days){
        this.lat = lat;
        this.lon = lon;
        this.days = days;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public short getDays() {
        return days;
    }

    public void setDays(short days) {
        this.days = days;
    }
}
