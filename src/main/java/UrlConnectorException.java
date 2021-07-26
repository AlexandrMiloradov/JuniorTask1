import java.io.IOException;

public class UrlConnectorException extends IOException {

    String message;

    UrlConnectorException(String message){
        super(message);
    }
}
