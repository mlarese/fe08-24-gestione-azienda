package it.epicode.gestione_azienda.dipendente;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

    List<Dipendente> findByCognome(String cognome);
    Dipendente findByNomeAndCognome(String nome, String cognome);
    Dipendente findByMatricola(String matricola);
    Dipendente findByDataAssunzione(LocalDate dataAssunzione);
    Dipendente findByDataNascita(LocalDate dataNascita);

    boolean existsByMatricola(String matricola);
    boolean existsByNomeAndCognome(String nome, String cognome);
    boolean existsByDataAssunzione(LocalDate dataAssunzione);
    boolean existsByDataNascita(LocalDate dataNascita);
    boolean existsByCognome(String cognome);

}
