import Weather.Weather;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

class Bot extends TelegramLongPollingBot {

    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>> T execute(Method method) throws TelegramApiException {
        return super.execute(method);
    }

    @Override
    public void onUpdateReceived(Update update) {

        long chatId = update.getMessage().getChatId();
        String location = update.getMessage().getText();
        System.out.println(chatId);
        if (update.getMessage().hasText()) {

            switch (update.getMessage().getText().toLowerCase()) {
                case "/start": // тестовый вариант ответа
                    try {
                        execute(new SendMessage(chatId, "Привет, я помогу узнать температуру воздуха за окном." +
                                " Для этого введи название города"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "привет": // тестовый вариант ответа
                    try {
                        execute(new SendMessage(chatId, "Привет,как дела?"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "хорошо": // тестовый вариант ответа номер 2
                    try {
                        execute(new SendMessage(chatId, "У меня тоже) " +
                                "Подсказать тебе погоду?" +
                                "Для этого надо написать название города "));
                        break;

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "понедельник":
                    try {
                        execute(new SendMessage(chatId, "На прогулку по центру в 17 00" +
                                " или на тернировку боксу на 19 30."));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "вторник":
                    try {
                        execute(new SendMessage(chatId, "В качалку на 17 00 , " +
                                "потом на лучиано за корзинками."));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "пятница": // тестовый вариант ответа на день недели номер 5
                    try {
                        execute(new SendMessage(chatId, "Это святой день. На 20 00 Баня. " +
                                "Купить два лимона и пачку чая."));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "погода": // как запросить прогноз погоды
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
