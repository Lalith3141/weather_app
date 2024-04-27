package Weather.demo.client;

import org.springframework.web.reactive.function.client.WebClient;


public class WorldWeather {
    

    public String fetchCityCodeClient() {
        WebClient.Builder webClientBuilder = WebClient.builder();
 
        return  webClientBuilder.build()
            .get()
            .uri("https://worldweather.wmo.int/en/json/full_city_list.txt")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }

    
}
