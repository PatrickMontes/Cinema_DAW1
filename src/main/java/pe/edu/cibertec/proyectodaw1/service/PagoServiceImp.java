package pe.edu.cibertec.proyectodaw1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Pago;
import pe.edu.cibertec.proyectodaw1.repository.PagoRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PagoServiceImp implements  PagoService{

    private PagoRepository repository;

    @Override
    public Pago insertaActualizaPago(Pago obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaPago(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pago> listaTodos() {
        return repository.findAll();
    }


    @Override
    public Optional<Pago> buscaPorId(int id) {
        return repository.findById(id);
    }
}
