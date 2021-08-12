import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotWeather extends TelegramLongPollingBot {
    public BotWeather(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    public BotWeather() {

    }

    @Override
    public String getBotUsername() {
        return "TestSweetSuper_bot";
    }

    @Override
    public String getBotToken() {
        return "1943920679:AAG6OQjTLBMtt1NgqCyuoU1fYFNn7CWDaf0";
    }

    @Override
    public void onUpdateReceived(Update update) {

        long chat_id = update.getMessage().getChatId();

        SendMessage message = new SendMessage();

        String botMessage = "";

        String userMess = update.getMessage().getText();

        if (userMess.equals("start")){
            botMessage = "Send the coordinate and count of days. Example: 56.8519 60.6122 3";
        } else {
            String[] userRequestArray = userMess.split(" ");
            FilterYandexWeatherData filterYandexWeatherData = new FilterYandexWeatherData();
            try{
                filterYandexWeatherData.setLat(Double.parseDouble(userRequestArray[0]));
                filterYandexWeatherData.setLon(Double.parseDouble(userRequestArray[1]));
                filterYandexWeatherData.setDays(Short.parseShort(userRequestArray[2]));

                Weather weather = YandexWeatherService.getWeatherForPlace(filterYandexWeatherData);

                ObjectMapper jsonMapper = new ObjectMapper();
                String jsonString = jsonMapper.writeValueAsString(weather);

                botMessage = jsonString;

            } catch(Exception ex){
                botMessage = "Wrong parameters !" + userMess;
            }
        }


        message.setChatId(String.valueOf(chat_id));

        message.setText(botMessage);

        try{
            execute(message);
        } catch (TelegramApiException ex){
            ex.printStackTrace();
        }

    }
}
