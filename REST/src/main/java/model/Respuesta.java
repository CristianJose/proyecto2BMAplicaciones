package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "respuesta")
public class Respuesta implements Serializable {
    @Id
    @Column(name = "id_respuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuesta;
    @Column(name = "opcion_respuesta")
    private String opcion_respuesta;
    @Column(name = "verificacion")
    private int verificacion;

    @OneToOne
    @JoinColumn(name="id_pregunta")
    private Pregunta id_pregunta;

    public Respuesta(Long id_respuesta, String opcion_respuesta, int verificacion) {
        this.id_respuesta = id_respuesta;
        this.opcion_respuesta = opcion_respuesta;
        this.verificacion = verificacion;
    }

    public Respuesta() {
    }

    public Long getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(Long id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getOpcion_respuesta() {
        return opcion_respuesta;
    }

    public void setOpcion_respuesta(String opcion_respuesta) {
        this.opcion_respuesta = opcion_respuesta;
    }

    public int getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(int verificacion) {
        this.verificacion = verificacion;
    }

    public Pregunta getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(Pregunta id_pregunta) {
        this.id_pregunta = id_pregunta;
    }
}
