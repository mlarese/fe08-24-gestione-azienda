package it.epicode.gestione_azienda.runners;

import com.github.javafaker.Faker;
import it.epicode.gestione_azienda.aziende.Azienda;
import it.epicode.gestione_azienda.aziende.AziendaRepository;
import it.epicode.gestione_azienda.dipendente.Dipendente;
import it.epicode.gestione_azienda.dipendente.DipendenteRepository;
import it.epicode.gestione_azienda.uffici.Ufficio;
import it.epicode.gestione_azienda.uffici.UfficioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class CreateDBRunner implements CommandLineRunner {
    private final Faker faker;
    private final UfficioRepository ufficioRepository;
    private final DipendenteRepository dipendenteRepository;
    private final AziendaRepository aziendaRepository;
    private final Azienda azienda;

    @Override
    public void run(String... args) throws Exception {
       // creo uffici

        for (int i = 0; i < 40; i++) {
            Ufficio ufficio = new Ufficio();
            ufficio.setNome(faker.company().name());
            ufficioRepository.save(ufficio);

        }

        List<Ufficio> uffici = ufficioRepository.findAll();

        // dipendenti
        for (int i = 0; i < 30; i++) {
            Dipendente dipendente = new Dipendente();
            dipendente.setNome(faker.name().firstName());
            dipendente.setCognome(faker.name().lastName());
            dipendente.setDataNascita(LocalDate.of(faker.number().numberBetween(1950, 2000), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28)));
            dipendente.setDataAssunzione(LocalDate.of(faker.number().numberBetween(2000, 2021), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28)));

            dipendente.setStipendio(faker.number().randomDouble(2, 2500, 5000));
            dipendente.setMatricola(faker.bothify("##-##-##"));
            dipendente.setUffici(List.of(
                    uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size())),
                    uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size()))
            ));
            dipendenteRepository.save(dipendente);
        }

        // azienda
        for (int i = 0; i < 15; i++) {

            Azienda azienda = new Azienda();
            azienda.setDenominazione(faker.company().name());
            azienda.setPartitaIva(faker.number().digits(11));

            int k1 = faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size());
            int k2 = faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size());

            azienda.setUffici(
                    List.of(
                            uffici.get(k1),
                            uffici.get(k2)
                    )
            );

            aziendaRepository.save(azienda);
        }

        System.out.println("---- azienda presa dal config");
        azienda.setUffici(List.of(
                uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size())),
                uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size())),
                uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size())),
                uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size())),
                uffici.get(faker.number().numberBetween(faker.number().numberBetween(0, 39), uffici.size()))
        ));

        aziendaRepository.save(azienda);
        System.out.println(azienda);



    }
}
