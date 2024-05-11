package pe.edu.cibertec.crudhorarios.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.crudhorarios.Entidad.Horario;
import pe.edu.cibertec.crudhorarios.Repository.HorarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HorarioServiceImp implements  HorarioService{

    private HorarioRepository repository;

    @Override
    public Horario insertaActualizaHorario(Horario obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaHorario(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Horario> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<Horario> listaPorHorario(Date filtro) {
        return repository.listaPorHorario(filtro);
    }

    @Override
    public Optional<Horario> buscaPorId(int id) {
        return repository.findById(id);
    }
}
