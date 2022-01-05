import Weather.Weather;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {

        long chatId = update.getMessage().getChatId();
        String location = update.getMessage().getText();
        System.out.println(chatId);
        if (update.getMessage().hasText()) {

            switch (update.getMessage().getText().toLowerCase()) {
                case "/start":
                    try {
                        execute(new SendMessage(chatId, "Привет, я помогу узнать температуру воздуха за окном." +
                                " Для этого введи название города. "+
                                "\nHello, enter name of city and i'll tell you current weather. "));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "/weather":
                    try {
                        execute(new SendMessage(chatId, "Enter name of city."));
                        break;

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "/погода":
                    try {
                        execute(new SendMessage(chatId, "Напиши название города"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    try {
                        execute(new SendMessage(chatId, Weather.weatherRequest(location)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }

        }

    }

    @Override
    public String getBotUsername() {
        return "AlilaxBot";
    }

    @Override
    public String getBotToken() {
        return "2111416678:AAEraFlllIHvJO74C0y1JZQ5ezvrN_H_OxA";
    }


}
