import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class UrlConnector {

    private String urlString;
    private URL url;
    private HttpURLConnection con;

    public UrlConnector(){

    }

    public UrlConnector(String urlString){
        this.urlString = urlString;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    private void setTheHeadersToUrl(Map<String, String> headers){
        for (Map.Entry<String, String> entry: headers.entrySet()){
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void setTheParamsToUrl(Map<String, String> params){
        Iterator<Map.Entry<String, String>> itr = params.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, String> entry =  itr.next();
            urlString += entry.getKey()+"="+entry.getValue();
            if (itr.hasNext()){
                urlString +="&";
            }
        }
    }

    private void openConnection() throws IOException{
        try{
            url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException ex) {
            System.out.println("Wrong url address");
        }
    }

    private StringReader getAnswerFromUrl() throws IOException, UrlConnectorException {
        StringReader stringReader = null;

        int responseCode = con.getResponseCode();

        if (responseCode == 200){
            final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                stringReader = new StringReader(inputLine);
            }
        } else {
           throw new UrlConnectorException("Server send request with "+"["+Integer.toString(responseCode)+"] code");
        }

        return stringReader;
    }

    public StringReader sendRequest(RequestData requestData) throws IOException {

        setTheParamsToUrl(requestData.getParams());
        openConnection();
        setTheHeadersToUrl(requestData.getHeaders());
        return getAnswerFromUrl();
    }

}
