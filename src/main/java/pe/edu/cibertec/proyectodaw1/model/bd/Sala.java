package pe.edu.cibertec.proyectodaw1.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sala_id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;
}