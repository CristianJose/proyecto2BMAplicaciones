package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "respuestam")
public class Resp_M implements Serializable {

    @Id
    @Column(name = "id_respuestaM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuestaM;
    @Column(name = "id_pregunta")
    private String alternativa;
    @Column(name = "alternativa")
    private boolean rta;

    public Resp_M() {
    }

    public Resp_M(String alternativa, boolean rta) {
        this.alternativa = alternativa;
        this.rta = rta;
    }

    public Long getId_respuestaM() {
        return id_respuestaM;
    }

    public void setId_respuestaM(Long id_respuestaM) {
        this.id_respuestaM = id_respuestaM;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public boolean isRta() {
        return rta;
    }

    public void setRta(boolean rta) {
        this.rta = rta;
    }
}
