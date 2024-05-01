package pe.edu.cibertec.proyectodaw1.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Asientos")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiento_id")
    private Integer asiento_id;
    private String fila;
    private Integer numero;
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

}
