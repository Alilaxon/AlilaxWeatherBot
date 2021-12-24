package Weather;

abstract class WeatherOnRussian {

    public static String tempInRussian(int temperature) {
        int value = temperature;
        System.out.println(value);
        String start = "Cейчас ";
        String end = " цельсия в городе ";
        if (value == 0)
            return start + temperature + " градусов" + end;
        else if (value == -1 || value == 1)
            return start + temperature + " градус" + end;
        else if (value < 5 && value > -5)
            return start + temperature + " градуса" + end;
        else
            return start + temperature + " градусов" + end;
    }

    public static String firstUpperCase(String location) {
        return location.substring(0, 1).toUpperCase() + location.substring(1);
    }
}