package it.epicode.gestione_azienda.uffici;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class UfficioConfig {
    private final Faker faker;

    @Bean
    // fa si che vengano creati oggetti diversi ogni volta che si definisce una variabile di questo tipo
    @Scope("prototype")
    public Ufficio ufficio() {
        Ufficio u = new Ufficio();
        u.setNome(faker.company().name());
        return u;
    }
}
