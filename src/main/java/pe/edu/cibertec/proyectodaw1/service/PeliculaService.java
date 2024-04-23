package pe.edu.cibertec.proyectodaw1.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;
import pe.edu.cibertec.proyectodaw1.repository.PeliculaRepository;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }
}