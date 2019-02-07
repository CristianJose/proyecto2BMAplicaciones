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
    private String nom_respuestaM;
    @Column(name = "valor_respuestaM")
    private boolean valor_respuestaM;


    public Resp_M() {

    }

    public Resp_M(String nom_respuestaM, boolean valor_respuestaM) {
        this.nom_respuestaM = nom_respuestaM;
        this.valor_respuestaM = valor_respuestaM;
    }

    public Long getId_respuestaM() {
        return id_respuestaM;
    }

    public void setId_respuestaM(Long id_respuestaM) {
        this.id_respuestaM = id_respuestaM;
    }

    public String getNom_respuestaM() {
        return nom_respuestaM;
    }

    public void setNom_respuestaM(String nom_respuestaM) {
        this.nom_respuestaM = nom_respuestaM;
    }

    public boolean isValor_respuestaM() {
        return valor_respuestaM;
    }

    public void setValor_respuestaM(boolean valor_respuestaM) {
        this.valor_respuestaM = valor_respuestaM;
    }
}
