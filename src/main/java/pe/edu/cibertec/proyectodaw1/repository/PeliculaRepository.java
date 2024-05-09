package pe.edu.cibertec.proyectodaw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
@Query(value="Select * From peliculas Limit :limit ", nativeQuery = true)
    List<Pelicula>listarPeliculasTop(@Param("limit") Integer limit);
}
