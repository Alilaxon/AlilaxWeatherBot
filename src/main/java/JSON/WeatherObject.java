package JSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherObject {
    private WeatherCountry sys;
    public WeatherCondition[] weather;
    private WeatherMain main;

    public WeatherCountry getSys() {return sys;}

    public void setSys(WeatherCountry sys) {this.sys = sys;}

    public WeatherCondition[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherCondition[] weather) {
        this.weather = weather;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }
}


