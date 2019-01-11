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
    @Column(name = "id_cuestionario")
    private int id_cuestionario;
    @Column(name = "nom_preguntac")
    private String nom_preguntac;

    public Pre_C(int id_cuestionario, String nom_preguntac) {
        this.id_cuestionario = id_cuestionario;
        this.nom_preguntac = nom_preguntac;
    }

    public Pre_C() {
    }

    public Long getId_preguntac() {
        return id_preguntac;
    }

    public void setId_preguntac(Long id_preguntac) {
        this.id_preguntac = id_preguntac;
    }

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getNom_preguntac() {
        return nom_preguntac;
    }

    public void setNom_preguntac(String nom_preguntac) {
        this.nom_preguntac = nom_preguntac;
    }
}
