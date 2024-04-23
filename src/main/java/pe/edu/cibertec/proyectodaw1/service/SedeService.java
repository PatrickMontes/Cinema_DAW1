package pe.edu.cibertec.proyectodaw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectodaw1.model.bd.Sede;
import pe.edu.cibertec.proyectodaw1.repository.SedeRepository;

import java.util.List;

@Service
public class SedeService implements ISedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Sede> listarSedes() {
        return sedeRepository.findAll();
    }
}
