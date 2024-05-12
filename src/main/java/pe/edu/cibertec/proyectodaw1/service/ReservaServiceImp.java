package pe.edu.cibertec.proyectodaw1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Reserva;
import pe.edu.cibertec.proyectodaw1.repository.ReservaRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReservaServiceImp implements  ReservaService{

    private ReservaRepository repository;

    @Override
    public Reserva insertaActualizaReserva(Reserva obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaReserva(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Reserva> listaTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Reserva> buscaPorId(int id) {
        return repository.findById(id);
    }
}
