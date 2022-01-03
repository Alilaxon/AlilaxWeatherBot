package Weather;

import org.checkerframework.checker.units.qual.C;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeleteChatStickerSet;

public class WeatherOnEnglish {


    public static boolean checkEnglish(String str) {
        int counter = 0;
        char[] ABS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char City = str.charAt(1);
        for (int i = 0; i < ABS.length; i++) {
            if (City == ABS[i]) {
                counter++;
            }
        }
        if (counter == 1)
            return true;
        else
            return false;
    }
}