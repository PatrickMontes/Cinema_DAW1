package pe.edu.cibertec.proyectodaw1.service;

import pe.edu.cibertec.proyectodaw1.model.bd.Sede;

import java.util.List;

public interface ISedeService {
    List<Sede> listarSedes();
    void guardarSede(Sede sede);
    void actualizarSede(Sede sede);
    void eliminarSede(int sede_id);
}
