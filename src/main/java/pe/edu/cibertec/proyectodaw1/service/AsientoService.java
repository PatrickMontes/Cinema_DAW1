package pe.edu.cibertec.proyectodaw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Asiento;
import pe.edu.cibertec.proyectodaw1.repository.AsientoRepository;

import java.util.List;

@Service
public class AsientoService implements IAsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private SalaService salaService;

    @Override
    public List<Asiento> listarAsientos() {
        return asientoRepository.findAll();
    }
}