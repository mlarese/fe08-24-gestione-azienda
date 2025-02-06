package it.epicode.gestione_azienda.aziende;

import it.epicode.gestione_azienda.dipendente.Dipendente;
import it.epicode.gestione_azienda.uffici.Ufficio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aziende")

public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    private String denominazione;
    private String partitaIva;
    @ManyToMany
    private List<Ufficio> uffici;


}
