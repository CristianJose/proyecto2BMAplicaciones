package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "respuestas")
public class Respuestas implements Serializable {
    @Id
    @Column(name = "id_respuestas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuestas;
    private String pregunta;
    private String respuesta;

    public Respuestas() {
    }

    public Respuestas(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Long getId_respuestas() {
        return id_respuestas;
    }

    public void setId_respuestas(Long id_respuestas) {
        this.id_respuestas = id_respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
