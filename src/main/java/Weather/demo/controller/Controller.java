package Weather.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Weather.demo.service.FetchCoordinates;
import Weather.demo.service.ServiceNumbers;

@RestController
public class Controller {
    @Autowired
    FetchCoordinates fetchCoordinates;
    @Autowired
    ServiceNumbers serviceNumbers;

    @PostMapping("/weather")
    public HashMap<String, String> getWeather(@RequestBody List<String> city){
        return fetchCoordinates.fetchCityCode(city);
    }
    
}
