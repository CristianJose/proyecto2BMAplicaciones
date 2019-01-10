import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TestData {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setCod_cuestionario(1122);
        cuestionario.setNom_cuestionario("Cuestionario 6");
        session.save(cuestionario);

        Pregunta pregunta = new Pregunta();
        pregunta.setNom_pregunta("Pregunta01");
        session.save(pregunta);

        Respuesta respuesta = new Respuesta();
        respuesta.setOpcion_respuesta("Respuesta01");
        respuesta.setVerificacion(1);
        session.save(respuesta);
        /*
        Resultado resultado = new Resultado();
        resultado.setId_prueba(9);
        resultado.setId_pregunta(5);
        resultado.setValor(100);
        session.save(resultado);

        Resultado_corta resultado_corta = new Resultado_corta();
        resultado_corta.setId_prueba(9);
        resultado_corta.setId_pregunta(5);
        resultado.setValor(100);
        session.save(resultado_corta);*/

        transaction.commit();
        session.close();
    }
    }
