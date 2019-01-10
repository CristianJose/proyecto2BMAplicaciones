package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resultado")
public class Resultado implements Serializable {
    @Id
    @Column(name = "id_resultado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resultado;
    @Column(name = "id_prueba")
    private int id_prueba;
    @Column(name = "id_pregunta")
    private int id_pregunta;
    @Column (name = "valor")
    private int valor;



    public Resultado(Long id_resultado, int id_prueba, int id_pregunta, int valor) {
        this.id_resultado = id_resultado;
        this.id_prueba = id_prueba;
        this.id_pregunta = id_pregunta;
        this.valor = valor;
    }

    public Resultado() {
    }

    public Long getId_resultado() {
        return id_resultado;
    }

    public void setId_resultado(Long id_resultado) {
        this.id_resultado = id_resultado;
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
