package it.epicode.gestione_azienda.runners;


import it.epicode.gestione_azienda.uffici.Ufficio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestPrototypeRunnerRunner implements CommandLineRunner {
    private final Ufficio ufficio1;
    private final Ufficio ufficio2;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("---- Ufficio1 ----");
        System.out.println(ufficio1);
        System.out.println("---- Ufficio2 ----");
        System.out.println(ufficio2);
    }
}
