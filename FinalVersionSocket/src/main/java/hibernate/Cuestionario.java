package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cuestionario")
public class Cuestionario implements Serializable {

    @Id
    @Column(name = "id_cuestionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cuestionario;
    @Column(name = "cuestionario")
    private String cuestionario;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cuestionario_PreOpcMult")
    private List<Pre_Multiple> preguntasMultiples;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cuestionario_PreOpcVf")
    private List<Pre_Vf> preguntasVF;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cuestionario_PreC")
    private List<Pre_C> preguntasCortas;

    public Cuestionario() {
    }

    public Cuestionario(String cuestionario, List<Pre_Multiple> preguntasMultiples, List<Pre_Vf> preguntasVF, List<Pre_C> preguntasCortas) {
        this.cuestionario = cuestionario;
        this.preguntasMultiples = preguntasMultiples;
        this.preguntasVF = preguntasVF;
        this.preguntasCortas = preguntasCortas;
    }

    public Long getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(Long id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(String cuestionario) {
        this.cuestionario = cuestionario;
    }

    public List<Pre_Multiple> getPreguntasMultiples() {
        return preguntasMultiples;
    }

    public void setPreguntasMultiples(List<Pre_Multiple> preguntasMultiples) {
        this.preguntasMultiples = preguntasMultiples;
    }

    public List<Pre_Vf> getPreguntasVF() {
        return preguntasVF;
    }

    public void setPreguntasVF(List<Pre_Vf> preguntasVF) {
        this.preguntasVF = preguntasVF;
    }

    public List<Pre_C> getPreguntasCortas() {
        return preguntasCortas;
    }

    public void setPreguntasCortas(List<Pre_C> preguntasCortas) {
        this.preguntasCortas = preguntasCortas;
    }
}
