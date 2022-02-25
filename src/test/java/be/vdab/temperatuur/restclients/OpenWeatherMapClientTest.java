package be.vdab.temperatuur.restclients;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OpenWeatherMapClientTest {
    private final OpenWeatherMapClient client;

    OpenWeatherMapClientTest(OpenWeatherMapClient client) {
        this.client = client;
    }

    @Test
    void temperatuurInIeper() {
        //        System.out.println(client.findByGemeente("Ieper"));
        assertThat(client.getTemperatuur("Ieper")).
                hasValueSatisfying(temperatuur ->
/*                    assertThat(temperatuur).isGreaterThanOrEqualTo(BigDecimal.valueOf(-60));
                    assertThat(temperatuur).isLessThanOrEqualTo(BigDecimal.valueOf(60));*/
                                assertThat(temperatuur).isBetween(BigDecimal.valueOf(-60), BigDecimal.valueOf(60))
                );
    }

    @Test
    void onbestaandeGemeente() {
        assertThat(client.getTemperatuur("xxx")).isEmpty();
    }
}