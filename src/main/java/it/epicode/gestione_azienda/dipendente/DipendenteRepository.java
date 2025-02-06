package it.epicode.gestione_azienda.dipendente;


import it.epicode.gestione_azienda.uffici.Ufficio;
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

    List<Dipendente> findByUffici(Ufficio ufficio);
    List<Dipendente> findByUfficiId(Long id);
    List<Dipendente> findByUfficiNome(String nome);

}
