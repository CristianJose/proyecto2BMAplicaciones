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
    @Column(name = "nom_vf")
    private String nom_vf;
    @Column(name = "res_vf")
    private boolean res_vf;
    @Column(name = "id_cuestionario")
    private int id_cuestionario;

    public Pre_Vf(String nom_vf, boolean res_vf, int id_cuestionario) {
        this.nom_vf = nom_vf;
        this.res_vf = res_vf;
        this.id_cuestionario = id_cuestionario;
    }

    public Pre_Vf() {
    }

    public Long getId_vf() {
        return id_vf;
    }

    public void setId_vf(Long id_vf) {
        this.id_vf = id_vf;
    }

    public String getNom_vf() {
        return nom_vf;
    }

    public void setNom_vf(String nom_vf) {
        this.nom_vf = nom_vf;
    }

    public boolean isRes_vf() {
        return res_vf;
    }

    public void setRes_vf(boolean res_vf) {
        this.res_vf = res_vf;
    }

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }
}
