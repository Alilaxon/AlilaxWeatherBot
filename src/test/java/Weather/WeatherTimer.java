package Weather;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class WeatherTimer {
    public static Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 19,
            1, 40, 15);
    public static Timer messegeTimer = new Timer();
    static TimerTask task = new TimerTask() {
        @Override
        public  void run() {

            System.out.println("Timer working");
        }

    };

    public static void inTime() {
        messegeTimer.schedule(task, date.getTime());

    }


}
