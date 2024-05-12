package pe.edu.cibertec.proyectodaw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibertec.proyectodaw1.model.bd.Pago;
import pe.edu.cibertec.proyectodaw1.model.bd.Reserva;

import java.util.Date;
import java.util.List;
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
}
