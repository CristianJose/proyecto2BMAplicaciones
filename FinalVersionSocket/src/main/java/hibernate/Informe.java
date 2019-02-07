package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "informe")
public class Informe implements Serializable {

    @Id
    @Column(name = "id_informe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_informe;
    private int id_cuestionario;
    private String nombreC;
    private String nombreE;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "informe_id_respuestas")
    private List<Respuestas> respuestas;


    public Informe(int id_cuestionario, String nombreC, String nombreE, List<Respuestas> respuestas) {
        this.id_cuestionario = id_cuestionario;
        this.nombreC = nombreC;
        this.nombreE = nombreE;
        this.respuestas = respuestas;
    }

    public Long getId_informe() {
        return id_informe;
    }

    public void setId_informe(Long id_informe) {
        this.id_informe = id_informe;
    }

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public List<Respuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuestas> respuestas) {
        this.respuestas = respuestas;
    }
}
