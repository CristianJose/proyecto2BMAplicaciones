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
    @Column(name = "nom_cuestionario")
    private String nom_cuestionario;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cuestionario_PreOpcMult")
    private List<Pre_Multiple> opcionMultiple;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cuestionario_PreOpcVf")
    private List<Pre_Vf> opcionVf;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cuestionario_PreC")
    private List<Pre_C> opcionC;

    public Cuestionario() {
    }

    public Cuestionario(String nom_cuestionario, List<Pre_Multiple> opcionMultiple, List<Pre_Vf> opcionVf, List<Pre_C> opcionC) {
        this.nom_cuestionario = nom_cuestionario;
        this.opcionMultiple = opcionMultiple;
        this.opcionVf = opcionVf;
        this.opcionC = opcionC;
    }

    public Long getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(Long id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getNom_cuestionario() {
        return nom_cuestionario;
    }

    public void setNom_cuestionario(String nom_cuestionario) {
        this.nom_cuestionario = nom_cuestionario;
    }

    public List<Pre_Multiple> getOpcionMultiple() {
        return opcionMultiple;
    }

    public void setOpcionMultiple(List<Pre_Multiple> opcionMultiple) {
        this.opcionMultiple = opcionMultiple;
    }

    public List<Pre_Vf> getOpcionVf() {
        return opcionVf;
    }

    public void setOpcionVf(List<Pre_Vf> opcionVf) {
        this.opcionVf = opcionVf;
    }

    public List<Pre_C> getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(List<Pre_C> opcionC) {
        this.opcionC = opcionC;
    }
}
