package pe.edu.cibertec.proyectodaw1.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sede_id;
    private String nombre;
    private String ubicacion;
}
