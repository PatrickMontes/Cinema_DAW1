package pe.edu.cibertec.proyectodaw1.model.dto.request;

public class AsientoRequest {
    private String fila;
    private Integer numero;
    private Integer salaId;

    // Constructores, getters y setters

    public AsientoRequest() {
    }

    public AsientoRequest(String fila, Integer numero, Integer salaId) {
        this.fila = fila;
        this.numero = numero;
        this.salaId = salaId;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }
}

