package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "preguntac")
public class Pre_C implements Serializable {

    @Id
    @Column(name = "id_preguntac")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_preguntac;
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "rta")
    private String rta;

    public Pre_C() {
    }

    public Pre_C(String pregunta, String rta) {
        this.pregunta = pregunta;
        this.rta = rta;
    }

    public Long getId_preguntac() {
        return id_preguntac;
    }

    public void setId_preguntac(Long id_preguntac) {
        this.id_preguntac = id_preguntac;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }
}
