package pe.edu.cibertec.proyectodaw1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibertec.proyectodaw1.model.bd.Horario;


import java.util.Date;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query("SELECT h FROM Horario h WHERE h.fecha = :fecha")
    List<Horario> listaPorHorario(@Param("fecha") Date fecha);
}
