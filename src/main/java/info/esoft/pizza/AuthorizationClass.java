package info.esoft.pizza;

import com.neovisionaries.ws.client.*;

public final class AuthorizationClass {
    private static final String SERVER = "wss://stream.pushbullet.com/websocket/o.Z77alssDKwkTsgyTpRr6q6EoOJIgSECm";

    //The timeout value in milliseconds for socket connection.
    private static final int TIMEOUT = 5000;
    private static WebSocket ws;

    public static boolean isWorked;
    public static String totalCode;

    public static void start() throws Exception {
        isWorked = true;
        connect();

        while(isWorked){

        }
        ws.clearListeners();
        ws.disconnect();
    }

    //Connect to the server.
    private static void connect() throws Exception
    {
        ws = new WebSocketFactory()
                .setConnectionTimeout(TIMEOUT)
                .createSocket(SERVER)
                .addListener(new WebSocketAdapter() {
                    // A text message arrived from the server.
                    public void onTextMessage(WebSocket websocket, String message) {

                        int index = message.indexOf("\"body\":");
                        String textMessage = message.substring(index,index + 32);
                        String code = textMessage.substring(textMessage.length()-5);
                        try{
                            Integer.parseInt(code);
                            totalCode = code;
                            isWorked = false;
                        }
                        catch (Exception ex){

                        }
                        System.out.println(totalCode);
                    }
                })
                .addExtension(WebSocketExtension.PERMESSAGE_DEFLATE)
                .connect();
    }
}