package pe.edu.cibertec.proyectodaw1.service;



import pe.edu.cibertec.proyectodaw1.model.bd.Reserva;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    public abstract Reserva insertaActualizaReserva(Reserva obj);
    public abstract void eliminaReserva(int id);
    public abstract List<Reserva> listaTodos();
    public abstract Optional<Reserva> buscaPorId(int id);

}
