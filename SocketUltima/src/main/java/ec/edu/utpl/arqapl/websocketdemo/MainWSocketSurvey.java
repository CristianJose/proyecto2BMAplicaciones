package ec.edu.utpl.arqapl.websocketdemo;

import ec.edu.utpl.arqapl.websocketdemo.handlers.SurveyWebSocketHandler;
import org.eclipse.jetty.websocket.api.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class MainWSocketSurvey {
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

    public static void main(String[] args) {

        webSocket("/index", SurveyWebSocketHandler.class);
        init();
    }
}
