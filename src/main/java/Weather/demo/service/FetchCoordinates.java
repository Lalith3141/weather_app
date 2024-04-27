package Weather.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Weather.demo.client.DataClient;
import Weather.demo.client.WorldWeather;

@Service
public class FetchCoordinates {

    public String fetchLatitudeLongitude(String locationName) {
        locationName = locationName.replaceAll(" ", "+");
        String apiurl = "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName
                + "&count=10&language=en&format=json";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(apiurl, String.class);
            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, String> fetchCityCode(List<String> citys) {
        HashMap<String, String> citycode = new HashMap<>();
        WorldWeather worldWeather = new WorldWeather();
        try {
            String responseBody = worldWeather.fetchCityCodeClient();
            String[] lines = responseBody.split("\n");
            for(String city : citys){
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length >= 3 && parts[1].equals("\"" + city + "\"")) {
                    String code= parts[2].replaceAll("\"", "").trim();
                     citycode.put(city, code);
                }
            }
        }
            return citycode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
