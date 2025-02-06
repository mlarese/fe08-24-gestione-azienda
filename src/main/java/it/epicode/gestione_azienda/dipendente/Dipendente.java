package it.epicode.gestione_azienda.dipendente;

import it.epicode.gestione_azienda.uffici.Ufficio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dipendenti")

public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //  nome string cognome string data_nascita localdate data_assunzione localdate stipendio double ufficio ufficio matricola string
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String cognome;
    private LocalDate dataNascita;
    private LocalDate dataAssunzione;
    private double stipendio;

    @ManyToMany
    // fa si che gli uffici non compaiano nel to string
    @ToString.Exclude
    private List<Ufficio> uffici;
    private String matricola;

}
