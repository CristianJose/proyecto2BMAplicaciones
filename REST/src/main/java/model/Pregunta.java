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

    @ManyToOne
    @JoinColumn(name="id_cuestionario")
    private Cuestionario id_cuestionario;

    public Pregunta(Long id_pregunta, String nom_pregunta) {
        this.id_pregunta=id_pregunta;
        this.nom_pregunta = nom_pregunta;
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

   }
