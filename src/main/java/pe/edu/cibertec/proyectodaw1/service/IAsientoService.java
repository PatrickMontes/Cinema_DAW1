package pe.edu.cibertec.proyectodaw1.service;

import pe.edu.cibertec.proyectodaw1.model.bd.Asiento;
import pe.edu.cibertec.proyectodaw1.model.dto.request.AsientoRequest;

import java.util.List;

public interface IAsientoService {
    List<Asiento> listarAsientos();
}