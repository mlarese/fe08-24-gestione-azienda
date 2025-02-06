package it.epicode.gestione_azienda.runners;


import it.epicode.gestione_azienda.aziende.AziendaRepository;
import it.epicode.gestione_azienda.dipendente.Dipendente;
import it.epicode.gestione_azienda.dipendente.DipendenteRepository;
import it.epicode.gestione_azienda.uffici.Ufficio;
import it.epicode.gestione_azienda.uffici.UfficioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)
public class TestDbRunner implements CommandLineRunner {
    private final UfficioRepository ufficioRepository;
    private final DipendenteRepository dipendenteRepository;
    private final AziendaRepository aziendaRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // test i metodi derivati del repository dipendente
        Dipendente dip1 = dipendenteRepository.findById(1L).get();
        Dipendente dip2 = dipendenteRepository.findByCognome(dip1.getCognome()).get(0);

        System.out.println("----------------- findByCognome");
        System.out.println(dip2);

        System.out.println("----------------- existsByCognome");
        boolean dip1exist=dipendenteRepository.existsByCognome(dip1.getCognome());
        System.out.println("Esiste " + dip1exist);

        System.out.println("----------------- findByNomeAndCognome");
        dip2 = dipendenteRepository.findByNomeAndCognome(dip1.getNome(), dip1.getCognome());
        System.out.println(dip2);


        System.out.println("----------------- findByUfficiId");
        // recupera uno degli id ufficio assegnato a uno o più dipendenti
        Long idUff  = dip2.getUffici().get(0).getId();
        List<Dipendente> dipendenti = dipendenteRepository.findByUfficiId(idUff);
        System.out.println(dipendenti);


    }
}
