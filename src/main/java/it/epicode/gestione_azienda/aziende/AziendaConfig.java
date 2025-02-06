package it.epicode.gestione_azienda.aziende;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AziendaConfig {

    @Bean
    public Azienda azienda() {
        Azienda a= new Azienda();
        a.setDenominazione("Luxottica s.p.a");
        a.setPartitaIva("12345678901");
        return a;
    }
}
