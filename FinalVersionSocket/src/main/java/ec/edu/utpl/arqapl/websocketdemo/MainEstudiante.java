package ec.edu.utpl.arqapl.websocketdemo;

import com.google.gson.Gson;
import ec.edu.utpl.arqapl.websocketdemo.handlers.Estudiante;
import hibernate.Cuestionario;
import hibernate.Informe;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.init;
import static spark.Spark.webSocket;

public class MainEstudiante {
    public static org.hibernate.Session session;
    public static Transaction transaction;
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

    public static void main(String[] args) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        webSocket("/estudiante", Estudiante.class);
        init();
    }

    public static void broadcastMessage(String sender, String message) {
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(leer(Integer.valueOf(message)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
//aqui debo cambiar segun la base de datos amigo yo
    public static  String leer(int id){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        String query = "FROM Cuestionario WHERE id_cuestionario = " + id;
        String json = "";
        try{
            TypedQuery<Cuestionario> myQuery = session.createQuery(query, Cuestionario.class);
            Gson gson = new Gson();
            json = gson.toJson(myQuery.getSingleResult());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        session.close();
        return json;
    }

    public static void saveQuiz(String message){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        var gson = new Gson();
        var cuestionario = gson.fromJson(message, Cuestionario.class);
        transaction = session.beginTransaction();
        session.save(cuestionario);
        transaction.commit();
        session.close();
    }
//guardar resultados modificar pilas
    public static void saveResults(String message){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        var gson = new Gson();
        var results = gson.fromJson(message, Informe.class);
        transaction = session.beginTransaction();
        session.save(results);
        transaction.commit();
        session.close();
    }
}
