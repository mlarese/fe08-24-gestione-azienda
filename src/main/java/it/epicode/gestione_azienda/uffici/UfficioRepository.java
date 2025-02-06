package it.epicode.gestione_azienda.uffici;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UfficioRepository extends JpaRepository<Ufficio, Long> {
    Ufficio findByNome(String nome);
    boolean existsByNome(String nome);
}
