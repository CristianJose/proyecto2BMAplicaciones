package ec.edu.utpl.arqapl.websocketdemo;

import ec.edu.utpl.arqapl.websocketdemo.handlers.SurveyWebSocketHandler;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class MainWSocketSurvey {
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

    public static void main(String[] args) {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        webSocket("/index", SurveyWebSocketHandler.class);
        init();
    }
}
