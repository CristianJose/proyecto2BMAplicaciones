package ec.edu.utpl.arqapl.websocketdemo.handlers;

import ec.edu.utpl.arqapl.websocketdemo.MainEstudiante;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
// tengo que modificar segun el main estudiante
@WebSocket
public class Estudiante {
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        String username = "User" + MainEstudiante.userNumber.incrementAndGet();
        MainEstudiante.userUsernameMap.put(session, username);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        String username = MainEstudiante.userUsernameMap.get(session);
        MainEstudiante.userUsernameMap.remove(session);
        System.out.println("Conexion close");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        System.out.println(message);
        boolean bandera;
        try{
            Integer.parseInt(message);
            bandera = true;
        }catch (Exception ex){
            bandera = false;
            System.out.println(ex.getMessage());
        }
        if(bandera == true){
            MainEstudiante.broadcastMessage(MainEstudiante.userUsernameMap.get(user), message);
        }else{
            MainEstudiante.saveResults(message);
        }
    }
}
