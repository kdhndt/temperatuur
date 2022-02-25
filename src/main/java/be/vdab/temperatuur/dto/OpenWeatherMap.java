package be.vdab.temperatuur.dto;

import java.math.BigDecimal;


//weather?q=Ieper
//we zoeken naar Weather, gebaseerd op plaats, net zoals user/2
//we krijgen de buitenste class Weather terug, met verschillende andere objecten binnenin, zoals "main" met het attribuut "temp"
public record OpenWeatherMap(Main main) {
    //OpenWeatherMap is betere naamgeving dan "Weather", we weten zo over welke service het gaat
}
