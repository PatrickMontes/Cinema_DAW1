package pe.edu.cibertec.proyectodaw1.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Asientos")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asiento_id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    private String fila;
    private Integer numero;
    private Boolean disponible;
}