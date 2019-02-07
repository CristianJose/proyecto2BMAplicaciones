package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "preguntavf")
public class Pre_Vf implements Serializable {

    @Id
    @Column(name = "id_vf")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vf;
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "rta")
    private boolean rta;

    public Pre_Vf() {
    }

    public Pre_Vf(String pregunta, boolean rta) {
        this.pregunta = pregunta;
        this.rta = rta;
    }

    public Long getId_vf() {
        return id_vf;
    }

    public void setId_vf(Long id_vf) {
        this.id_vf = id_vf;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isRta() {
        return rta;
    }

    public void setRta(boolean rta) {
        this.rta = rta;
    }
}
