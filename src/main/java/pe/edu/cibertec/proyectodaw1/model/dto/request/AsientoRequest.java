package pe.edu.cibertec.proyectodaw1.model.dto.request;

import lombok.Data;

@Data
public class AsientoRequest {
    private Integer salaId;
    private String fila;
    private Integer numero;
    private Boolean disponible;
}
