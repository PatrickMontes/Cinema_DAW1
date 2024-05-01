package pe.edu.cibertec.proyectodaw1.service;

import pe.edu.cibertec.proyectodaw1.model.bd.Sala;

import java.util.List;

public interface ISalaService {
    List<Sala> listarSalas();
    void guardarSala(Sala sala);
    void actualizarSala(Sala sala);
    void eliminarSala(int sala_id);

    void eliminarSalaPorId(Integer id);
}
