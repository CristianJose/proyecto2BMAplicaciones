package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pre_Multiple implements Serializable {

    @Id
    @Column(name = "id_pregunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pregunta;
    @Column(name = "nom_pregunta")
    private String nom_pregunta;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pre_M_idOpPreMult")
    private List<Resp_M> respuestaM;


    public Pre_Multiple() {

    }

    public Pre_Multiple(String nom_pregunta, List<Resp_M> respuestaM) {
        this.nom_pregunta = nom_pregunta;
        this.respuestaM = respuestaM;
    }

    public Long getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(Long id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getNom_pregunta() {
        return nom_pregunta;
    }

    public void setNom_pregunta(String nom_pregunta) {
        this.nom_pregunta = nom_pregunta;
    }

    public List<Resp_M> getRespuestaM() {
        return respuestaM;
    }

    public void setRespuestaM(List<Resp_M> respuestaM) {
        this.respuestaM = respuestaM;
    }
}