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
    @Column(name = "nom_preguntac")
    private String nom_preguntac;
    @Column(name = "respuesta")
    private String respuesta;


    public Pre_C() {

    }

    public Pre_C(String nom_preguntac, String respuesta) {
        this.nom_preguntac = nom_preguntac;
        this.respuesta = respuesta;
    }

    public Long getId_preguntac() {
        return id_preguntac;
    }

    public void setId_preguntac(Long id_preguntac) {
        this.id_preguntac = id_preguntac;
    }

    public String getNom_preguntac() {
        return nom_preguntac;
    }

    public void setNom_preguntac(String nom_preguntac) {
        this.nom_preguntac = nom_preguntac;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
