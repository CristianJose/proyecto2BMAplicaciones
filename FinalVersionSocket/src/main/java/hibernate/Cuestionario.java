package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuestionario")
public class Cuestionario implements Serializable {

    @Id
    @Column(name = "id_cuestionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cuestionario;
    @Column(name = "cod_cuestionario")
    private int cod_cuestionario;
    @Column(name = "nom_cuestionario")
    private String nom_cuestionario;

    public Cuestionario(int cod_cuestionario, String nom_cuestionario) {
        this.cod_cuestionario = cod_cuestionario;
        this.nom_cuestionario = nom_cuestionario;
    }

    public Cuestionario() {
    }

    public Long getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(Long id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public int getCod_cuestionario() {
        return cod_cuestionario;
    }

    public void setCod_cuestionario(int cod_cuestionario) {
        this.cod_cuestionario = cod_cuestionario;
    }

    public String getNom_cuestionario() {
        return nom_cuestionario;
    }

    public void setNom_cuestionario(String nom_cuestionario) {
        this.nom_cuestionario = nom_cuestionario;
    }
}
