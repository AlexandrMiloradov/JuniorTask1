import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class infoPlace {

    private double lat;
    private double lon;
    private timeZone tzinfo;
    private double def_pressure_mm;
    private double def_pressure_pa;
    private String url;

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

    public timeZone getTzinfo() {
        return tzinfo;
    }

    public void setTzinfo(timeZone tzinfo) {
        this.tzinfo = tzinfo;
    }

    public double getDef_pressure_mm() {
        return def_pressure_mm;
    }

    public void setDef_pressure_mm(double def_pressure_mm) {
        this.def_pressure_mm = def_pressure_mm;
    }

    public double getDef_pressure_pa() {
        return def_pressure_pa;
    }

    public void setDef_pressure_pa(double def_pressure_pa) {
        this.def_pressure_pa = def_pressure_pa;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
