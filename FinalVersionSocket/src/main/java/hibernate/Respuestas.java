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
    private String preg;
    private String rta;

    public Respuestas() {
    }

    public Respuestas(String preg, String rta) {
        this.preg = preg;
        this.rta = rta;
    }

    public Long getId_respuestas() {
        return id_respuestas;
    }

    public void setId_respuestas(Long id_respuestas) {
        this.id_respuestas = id_respuestas;
    }

    public String getPreg() {
        return preg;
    }

    public void setPreg(String preg) {
        this.preg = preg;
    }

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }
}
