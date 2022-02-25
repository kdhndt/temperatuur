package be.vdab.temperatuur.restclients;

import be.vdab.temperatuur.dto.OpenWeatherMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.math.BigDecimal;
import java.util.Optional;

@Component
//implementatie van WeatherClient die de API van OpenWeatherMap gebruikt (betere naamgeving dan DefaultOpenWeatherMapClient...)
class OpenWeatherMapClient implements WeatherClient {
    private final WebClient client;
    private final String uri;

    //naamvanrestservice.weather, naamgeving mag gelijk wat zijn maar het komt er op neer dat we met van de service weather informatie ophalen
    OpenWeatherMapClient(WebClient.Builder builder, @Value("${openweathermapapi}") String uri) {
        client = builder.build();
        this.uri = uri;
    }

    @Override
    public Optional<BigDecimal> getTemperatuur(String gemeente) {
        try {
            return Optional.of(client.get()
                    .uri(uri, gemeente)
                    .retrieve()
                    .bodyToMono(OpenWeatherMap.class)
                    .block()
                    //JSON data werd geconvert naar een Weather class, nu kan je _NA_ je .block() toegang krijgen tot attributen
                    .main().temp()
            );
        } catch (WebClientResponseException.NotFound ex) {
            return Optional.empty();
        }
    }
}