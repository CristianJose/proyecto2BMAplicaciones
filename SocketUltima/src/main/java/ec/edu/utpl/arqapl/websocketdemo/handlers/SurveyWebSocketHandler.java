package ec.edu.utpl.arqapl.websocketdemo.handlers;

import com.google.gson.*;
import ec.edu.utpl.arqapl.websocketdemo.MainWSocketSurvey;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class SurveyWebSocketHandler {
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        String username = "User" + MainWSocketSurvey.userNumber.incrementAndGet();
        MainWSocketSurvey.userUsernameMap.put(session, username);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        String username = MainWSocketSurvey.userUsernameMap.get(session);
        MainWSocketSurvey.userUsernameMap.remove(session);
        System.out.println("Conexion close");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        System.out.println(message);
        readJson(message);
        //System.out.println(message);
        //MainWSocketSurvey.broadcastMessage(MainWSocketSurvey.userUsernameMap.get(user), message);
    }

    private void readJson(String message){

        JsonParser parser = new JsonParser();
        JsonArray gsonArr = parser.parse(message).getAsJsonArray();
        System.out.println(gsonArr);
        for(JsonElement obj: gsonArr){

            JsonObject gsonObj = obj.getAsJsonObject();
            // String nameQuiz = gsonObj.get("nom_cuestionario").getAsString();
            String nombre_cuestionario = gsonObj.get("nom_cuestionario").getAsString();
            JsonArray opcionMultiple = gsonObj.get("opcionMultiple").getAsJsonArray();
            //System.out.println("Nombre del cuestionario: " + nameQuiz); // asdasdad
            System.out.println("Nombre del cuestionario: " + nombre_cuestionario); // asdasdad

            if(opcionMultiple.size() != 0){
                for(int i = 0; i < opcionMultiple.size(); i++){
                    //JsonObject gsonObj2 = opcionMultiple.get(i).getAsJsonObject();
                    JsonObject gsonObj2 = opcionMultiple.get(i).getAsJsonObject();
                    String pregunta = gsonObj2.get("pregunta").getAsString();
                    System.out.println("pregunta: " + pregunta); //asdadsad
                    JsonArray opciones = gsonObj2.get("opciones").getAsJsonArray();
                    for(int j = 0; j < opciones.size(); j++){
                        JsonObject gsonObj3 = opciones.get(j).getAsJsonObject();
                        String opcion = gsonObj3.get("opcion").getAsString();
                        Boolean respuesta = gsonObj3.get("respuesta").getAsBoolean();
                        System.out.println("Opcion: " + opcion + " respuesta: " + respuesta); // adsadasd

                    }
                }
            }

            JsonArray opcionvf = gsonObj.get("opcionvf").getAsJsonArray();
            if(opcionvf.size() != 0){
                for(int i = 0; i < opcionvf.size(); i++){
                    JsonObject gsonObj2 = opcionvf.get(i).getAsJsonObject();
                    String pregunta = gsonObj2.get("pregunta").getAsString();
                    System.out.println("pregunta: " + pregunta); //asdadsad
                    Boolean respuesta = gsonObj2.get("respuesta").getAsBoolean();
                    System.out.println("respuesta: " + respuesta); // adsadasd
                }
            }


            JsonArray opcionCorta = gsonObj.get("opcionCorta").getAsJsonArray();
            if(opcionCorta.size() != 0){
                for(int i = 0; i < opcionCorta.size(); i++){
                    JsonObject gsonObj2 = opcionCorta.get(i).getAsJsonObject();
                    String pregunta = gsonObj2.get("pregunta").getAsString();
                    System.out.println("Pregunta: " + pregunta);

                    String respuesta = gsonObj2.get("respuesta").getAsString();
                    System.out.println("respuesta: " + respuesta); // adsadasd
                    
                }
            }
        }
    }
}