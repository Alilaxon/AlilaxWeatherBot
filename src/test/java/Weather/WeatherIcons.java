package Weather;

abstract class WeatherIcons {
    public static String Icons(String condition) {
        String rus = " ";
        switch (condition) {
            case "Clear":
                rus = " ☀";
                break;
            case "Clouds":
                rus = " ☁";
                break;
            case "Rain":
                rus = " ☔";
                break;
            case "Snow":
                rus = " ❄";
                break;
            default:
                rus = " ";
                break;
        }
        return rus;
    }
}
