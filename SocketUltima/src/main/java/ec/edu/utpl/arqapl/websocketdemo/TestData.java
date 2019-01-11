package ec.edu.utpl.arqapl.websocketdemo;
import hibernate.question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TestData {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //Ingresar cuestionario

        question cuestionario = new question();
        cuestionario.setQuestion_q("Cuestionario probando");
        session.save(cuestionario);

        transaction.commit();
        session.close();
    }
}