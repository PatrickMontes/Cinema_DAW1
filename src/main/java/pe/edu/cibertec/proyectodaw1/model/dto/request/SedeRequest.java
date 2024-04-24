package pe.edu.cibertec.proyectodaw1.model.dto.request;

import lombok.Data;

@Data
public class SedeRequest {
    private Integer sede_id;
    private String nombre;
    private String ubicacion;
}
