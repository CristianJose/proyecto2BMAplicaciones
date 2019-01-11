package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questionShortAnswer")
public class question implements Serializable {

    @Id
    @Column(name = "id_q")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_q;
    @Column(name = "question_q")
    private String question_q;

    public question(String question_q) {
        this.question_q = question_q;
    }

    public question() {
    }

    public Long getId_q() {
        return id_q;
    }

    public void setId_q(Long id_q) {
        this.id_q = id_q;
    }

    public String getQuestion_q() {
        return question_q;
    }

    public void setQuestion_q(String question_q) {
        this.question_q = question_q;
    }
}
