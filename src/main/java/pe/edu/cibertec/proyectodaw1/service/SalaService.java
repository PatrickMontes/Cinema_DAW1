package pe.edu.cibertec.proyectodaw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Sala;
import pe.edu.cibertec.proyectodaw1.repository.SalaRepository;

import java.util.List;

@Service
public class SalaService implements ISalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    @Override
    public void guardarSala(Sala sala) {
        salaRepository.save(sala);
    }

    @Override
    public void eliminarSalaPorId(Integer id) {
        salaRepository.deleteById(id);
    }

    @Override
    public Sala obtenerSalaPorId(Integer salaId) {
        return salaRepository.findById(salaId).orElse(null);
    }
}
