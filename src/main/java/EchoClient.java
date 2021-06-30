import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import com.neovisionaries.ws.client.*;

public class EchoClient {
    private static final String SERVER = "wss://stream.pushbullet.com/websocket/o.Z77alssDKwkTsgyTpRr6q6EoOJIgSECm";

    //The timeout value in milliseconds for socket connection.
    private static final int TIMEOUT = 5000;

    private static boolean isWorked;

    //The entry point of this command line application.
    public static void main(String[] args) throws Exception
    {
        // Connect to the echo server.
        isWorked = true;
        WebSocket ws = connect();

        // A text read from the standard input.
        String text;

        while(isWorked){

        }
        // Read lines until "exit" is entered.

        // Close the web socket.
        ws.disconnect();
    }

    //Connect to the server.
    private static WebSocket connect() throws Exception
    {
        return new WebSocketFactory()
                .setConnectionTimeout(TIMEOUT)
                .createSocket(SERVER)
                .addListener(new WebSocketAdapter() {
                    // A text message arrived from the server.
                    public void onTextMessage(WebSocket websocket, String message) {
                        JSONParser parser = new JSONParser();
                        Object object = new Object();
                        try{
                            object = parser.parse(message);
                        }catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }

                        JSONObject jsonObject = (JSONObject) object;
                        // System.out.println("Object: " + jsonObject);

                        JSONObject pushObject = (JSONObject) jsonObject.get("push");
                        System.out.println(pushObject.toString());

                        JSONArray notifications = (JSONArray) pushObject.get("notifications");
                        System.out.println("List notifications: " + notifications.toString());

                        JSONObject notification = (JSONObject) notifications.get(0);
                        System.out.println("First notification: " + notification.toString());

                        String code = (String) notification.get("body");
                        System.out.println("code: " + code.toString());

                        if (message.contains("body")) {

                        }
                        //System.out.println(message);
                    }
                })
                .addExtension(WebSocketExtension.PERMESSAGE_DEFLATE)
                .connect();
    }
}