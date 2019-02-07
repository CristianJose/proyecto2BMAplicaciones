package ec.edu.utpl.arqapl.websocketdemo;

import com.google.gson.Gson;
import ec.edu.utpl.arqapl.websocketdemo.handlers.SurveyWebSocketHandler;
import hibernate.Cuestionario;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class MainWSocketSurvey {
    public static org.hibernate.Session session;
    public static Transaction transaction;
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

    public static void main(String[] args) {
       session = HibernateUtil.getSessionFactory().getCurrentSession();
        webSocket("/profesor", SurveyWebSocketHandler.class);
        init();
    }


    public static void broadcastMessage(String sender, String message) {
        saveQuiz(message);
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(leer(Integer.valueOf(message)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    //aquie debo cambiar lo de la base de datos cristian
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


}
