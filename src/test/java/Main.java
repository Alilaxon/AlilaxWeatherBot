import Weather.WeatherTimer;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot telebot = new Bot();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(telebot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        WeatherTimer.inTime();
    }

}

