package pe.edu.cibertec.proyectodaw1.service;



import pe.edu.cibertec.proyectodaw1.model.bd.Pago;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    public abstract Pago insertaActualizaPago(Pago obj);
    public abstract void eliminaPago(int id);
    public abstract List<Pago> listaTodos();
    public abstract Optional<Pago> buscaPorId(int id);

}
