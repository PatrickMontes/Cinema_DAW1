package pe.edu.cibertec.proyectodaw1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;

import java.util.List;


public interface IPeliculaService {
    List<Pelicula>listarPeliculas();
    void guardarPelicula(Pelicula pelicula);
}
