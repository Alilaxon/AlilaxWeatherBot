package Weather;

import JSON.WeatherObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    final static String API_CALL = "http://api.openweathermap.org/data/2.5/weather?q=";
    final static String API_KEY = "&appid=003dc130f8a394bf877b6b930a70cdb4";


    public static String weatherRequest(String location) throws Exception {

        String urlString = API_CALL + location + API_KEY;
        URL urlObject = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            if (WeatherOnEnglish.checkEnglish(location) == true)
                return "Sorry. I don't understand you.\n Enter correct name of city.";
            else
            return "Извини, я тебя не понимаю."+
                    "\n Введи корректное название города.";
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String country = JSONGetCountry(response);
        String condition = JSONGetCondition(response);
        int temperature = JSONGetTemp(response);
        System.out.println(WeatherOnEnglish.checkEnglish(location));
        if(WeatherOnEnglish.checkEnglish(location) == true)
            return "Now "+temperature+ "° in "+
                    WeatherOnRussian.firstUpperCase(location)+
                    " ("+country+")"+
                    WeatherIcons.Icons(condition);
        else
        return WeatherOnRussian.tempInRussian(temperature) +
                WeatherOnRussian.firstUpperCase(location) +
                " ("+country+")"+
                WeatherIcons.Icons(condition);
    }

    public static int JSONGetTemp(StringBuffer response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        WeatherObject object = mapper.readValue(response.toString(), WeatherObject.class);
        return Math.round(object.getMain().getTemp()) - 273;
    }

    public static String JSONGetCondition(StringBuffer response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        WeatherObject object = mapper.readValue(response.toString(), WeatherObject.class);
        return object.getWeather()[0].getMain();
    }
    public static String JSONGetCountry(StringBuffer response) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        WeatherObject object = mapper.readValue(response.toString(), WeatherObject.class);
        return object.getSys().getCountry();
    }
}