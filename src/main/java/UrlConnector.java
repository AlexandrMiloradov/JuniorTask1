import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

    public void setTheHeadersToUrl(String nameHeader, String valueHeader){
            con.setRequestProperty(nameHeader, valueHeader);
    }

    public void openConnection() throws IOException{
        try{
            url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException ex) {
            System.out.println("Wrong url address");
        }
    }

    public StringReader getAnswerFromUrl()  {
        StringReader stringReader = null;
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                stringReader = new StringReader(inputLine);
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }

        return stringReader;
    }

}
