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
    private Long id_cuestionario;



    public Pregunta(Long id_pregunta, String nom_pregunta) {
        this.id_pregunta=id_pregunta;
        this.nom_pregunta = nom_pregunta;
        this.id_cuestionario = id_cuestionario;
    }

    public Pregunta() {
    }

    public  void consultarcuestionario (int codigo){
        Cuestionario buscar = new Cuestionario();
         int valor = buscar.getCod_cuestionario();
        if (codigo == valor){

        }

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

    public Long getId_cuestionario() { return id_cuestionario; }

    public void setId_cuestionario(Long id_cuestionario) { this.id_cuestionario = id_cuestionario; }
}
