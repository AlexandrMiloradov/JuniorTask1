import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;

public class UrlConnectorService {

    public static StringReader getAnswerFromUrl(HttpURLConnection con) throws IOException, UrlConnectorException {
        StringReader stringReader = null;

        int responseCode = con.getResponseCode();

        if (responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                stringReader = new StringReader(inputLine);
            }
        } else {
            throw new UrlConnectorException(String.format("Server send request with "+"[%s] code", Integer.toString(responseCode)));
        }

        return stringReader;
    }

}
