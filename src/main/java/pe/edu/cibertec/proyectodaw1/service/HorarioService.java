package pe.edu.cibertec.crudhorarios.Service;

import pe.edu.cibertec.crudhorarios.Entidad.Horario;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HorarioService {
    public abstract Horario insertaActualizaHorario(Horario obj);
    public abstract void eliminaHorario(int id);
    public abstract List<Horario> listaTodos();
    public abstract List<Horario> listaPorHorario(Date filtro);
    public abstract Optional<Horario> buscaPorId(int id);

}
