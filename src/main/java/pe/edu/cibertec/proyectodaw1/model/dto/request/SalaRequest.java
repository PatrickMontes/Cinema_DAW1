package pe.edu.cibertec.proyectodaw1.model.dto.request;

public class SalaRequest {
    private String nombre;
    private Integer sedeId; // Esto es opcional, dependiendo de cómo manejes las relaciones entre salas y sedes

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSedeId() {
        return sedeId;
    }

    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
    }
}