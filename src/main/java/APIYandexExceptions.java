public class APIYandexExceptions extends RuntimeException {

    String message;

    APIYandexExceptions(String message) {
        super(message);
    }
}
