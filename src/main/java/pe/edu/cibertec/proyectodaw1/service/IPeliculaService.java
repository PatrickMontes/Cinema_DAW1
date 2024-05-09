package pe.edu.cibertec.proyectodaw1.service;

import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;

import java.util.List;
import java.util.Optional;


public interface IPeliculaService {
    List<Pelicula>listarPeliculas();
    void guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer pelicula_id);

    Pelicula buscarPeliculaPorId(Integer id);

    List<Pelicula>listTop(int limit);


}
