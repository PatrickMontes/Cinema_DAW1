package pe.edu.cibertec.proyectodaw1.model.bd;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer peliculaid;
    private String titulo;
    private String genero;
    private String duracion;
    private String imagen;
    private Boolean disponible = true;
}
