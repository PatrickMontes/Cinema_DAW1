package pe.edu.cibertec.proyectodaw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
}