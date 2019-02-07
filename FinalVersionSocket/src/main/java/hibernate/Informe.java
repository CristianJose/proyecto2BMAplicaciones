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
    private String nombreCuest;
    private String student;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "informe_id_respuestas")
    private List<Respuestas> rtas;

    public Informe() {
    }

    public Informe(int id_cuestionario, String nombreCuest, String student, List<Respuestas> rtas) {
        this.id_cuestionario = id_cuestionario;
        this.nombreCuest = nombreCuest;
        this.student = student;
        this.rtas = rtas;
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

    public String getNombreCuest() {
        return nombreCuest;
    }

    public void setNombreCuest(String nombreCuest) {
        this.nombreCuest = nombreCuest;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<Respuestas> getRtas() {
        return rtas;
    }

    public void setRtas(List<Respuestas> rtas) {
        this.rtas = rtas;
    }
}
