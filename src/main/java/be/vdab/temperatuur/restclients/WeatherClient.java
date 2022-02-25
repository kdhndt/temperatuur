package be.vdab.temperatuur.restclients;

import java.math.BigDecimal;
import java.util.Optional;

//er bestaan verschillende API's voor WeatherClients
public interface WeatherClient {
    Optional<BigDecimal> getTemperatuur(String gemeente);
//    Optional<Weather> findByGemeente(String gemeente);

}
