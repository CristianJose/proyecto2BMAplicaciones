import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TestData {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //Ingresar cuestionario
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setCod_cuestionario(3333);
        cuestionario.setNom_cuestionario("Cuestionario 19995");
        session.save(cuestionario);

        //Ingresar pregunta
        /*Pregunta pregunta = new Pregunta();
        pregunta.setNom_pregunta("Pregunta funciona");

        session.save(pregunta);*/
/*
        //ingresar respuesta
        Respuesta respuesta = new Respuesta();
        respuesta.setOpcion_respuesta("Respuesta01");
        respuesta.setVerificacion(1);
        session.save(respuesta);
        *//*
        //Ingresar resultado
        Resultado resultado = new Resultado();
        resultado.setId_prueba(9);
        resultado.setId_pregunta(5);
        resultado.setValor(100);
        session.save(resultado);

        //Resultado corta
        Resultado_corta resultado_corta = new Resultado_corta();
        resultado_corta.setId_prueba(9);
        resultado_corta.setId_pregunta(5);
        resultado.setValor(100);
        session.save(resultado_corta);*/

        transaction.commit();
        session.close();
    }
    }
