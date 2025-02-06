package it.epicode.gestione_azienda.aziende;

import it.epicode.gestione_azienda.uffici.Ufficio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AziendaRepository extends JpaRepository<Azienda, Long> {
    Azienda findByDenominazione(String denominazione);
    Azienda findByPartitaIvaAndDenominazione(String partitaIva, String denominazione);
    Azienda findByPartitaIva(String partitaIva);

    boolean existsByDenominazione(String denominazione);
    boolean existsByPartitaIvaAndDenominazione(String partitaIva, String denominazione);
    boolean existsByPartitaIva(String partitaIva);

    int countByDenominazione(String denominazione);



}
