package ec.edu.utpl.arqapl.websocketdemo.handlers;

import com.google.gson.*;
import ec.edu.utpl.arqapl.websocketdemo.MainWSocketSurvey;
import hibernate.Cuestionario;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.hibernate.Transaction;
import util.HibernateUtil;


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
        readJson(message);
        //System.out.println(message);
        //MainWSocketSurvey.broadcastMessage(MainWSocketSurvey.userUsernameMap.get(user), message);
    }

    private void readJson(String message){

        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        JsonParser parser = new JsonParser();
        JsonArray gsonArr = parser.parse(message).getAsJsonArray();
        System.out.println(gsonArr);
        for(JsonElement obj: gsonArr){

            JsonObject gsonObj = obj.getAsJsonObject();
            System.out.println("hola antes desde aqui");
            // desde qui
            System.out.println("hola desde aqui");
            String nombre1_cuestionario = gsonObj.get("nomb_cuestionario").getAsString();
            JsonArray opcionMultiple = gsonObj.get("opcionMultiple").getAsJsonArray();
            System.out.println("Nombre del Cuestionario: " + nombre1_cuestionario);
            //agregando codigo
            int cod1_cuestionario = gsonObj.get("cod_cuestionario").getAsInt();
            System.out.println("Codigo del Cuestionario: " + cod1_cuestionario);

            Cuestionario c = new Cuestionario();
            c.setNom_cuestionario(nombre1_cuestionario);
            c.setCod_cuestionario(cod1_cuestionario);
            System.out.println(nombre1_cuestionario);
            System.out.println(nombre1_cuestionario);
            session.save(c);

            transaction.commit();
            session.close();

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