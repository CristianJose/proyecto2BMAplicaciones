package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pregunta")
public class Pregunta implements Serializable {
    @Id
    @Column(name = "id_pregunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pregunta;
    @Column(name = "nom_pregunta")
    private String nom_pregunta;
    @Column(name = "id_cuestionario")
    private int id_cuestionario;

    public Pregunta(Long id_pregunta, String nom_pregunta, int id_cuestionario) {
        this.id_pregunta=id_pregunta;
        this.nom_pregunta = nom_pregunta;
        this.id_cuestionario = id_cuestionario;
    }

    public Pregunta() {
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

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }
}
