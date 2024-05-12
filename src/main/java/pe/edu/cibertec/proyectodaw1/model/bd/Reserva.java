package pe.edu.cibertec.proyectodaw1.model.bd;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
@Entity
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reserva_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id")
    private Horario horarioId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asiento_id")
    private Asiento asiento_id;

    @Column(name = "estado_reserva")
    private String estado_reserva;

    @Column(name = "fecha_reserva")
    private Date fecha_reserva;

}