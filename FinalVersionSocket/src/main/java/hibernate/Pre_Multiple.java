package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "preguntaM")
public class Pre_Multiple implements Serializable {

    @Id
    @Column(name = "id_pregunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pregunta;
    @Column(name = "pregunta")
    private String pregunta;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pre_M_idOpPreMult")
    private List<Resp_M> alternativas;

    public Pre_Multiple() {
    }

    public Pre_Multiple(String pregunta, List<Resp_M> alternativas) {
        this.pregunta = pregunta;
        this.alternativas = alternativas;
    }

    public Long getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(Long id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<Resp_M> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Resp_M> alternativas) {
        this.alternativas = alternativas;
    }
}