package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "respuesta_corta")
public class Resultado_corta implements Serializable {
    @Id
    @Column(name = "id_resultado_corta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resultado_corta;
    @Column(name = "id_prueba")
    private int id_prueba;
    @Column(name = "id_pregunta")
    private int id_pregunta;
    @Column(name = "valor")
    private int valor;

    public Resultado_corta(Long id_resultado_corta, int id_prueba, int id_pregunta, int valor) {
        this.id_resultado_corta = id_resultado_corta;
        this.id_prueba = id_prueba;
        this.id_pregunta = id_pregunta;
        this.valor = valor;
    }

    public Resultado_corta() {
    }

    public Long getId_resultado_corta() {
        return id_resultado_corta;
    }

    public void setId_resultado_corta(Long id_resultado_corta) {
        this.id_resultado_corta = id_resultado_corta;
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
