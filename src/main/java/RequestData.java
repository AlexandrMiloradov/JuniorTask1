import java.util.LinkedHashMap;
import java.util.Map;

public class RequestData {

    private Map<String, String> headers = new LinkedHashMap<>();
    private Map<String, String> params = new LinkedHashMap<>();
    private String body;

    public RequestData() {

    }

    public RequestData(Map<String, String> headers, Map<String, String> params, String body) {
        this.headers = headers;
        this.params = params;
        this.body = body;
    }

    public RequestData(Map<String, String> headers, Map<String, String> params) {
        this.headers = headers;
        this.params = params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
