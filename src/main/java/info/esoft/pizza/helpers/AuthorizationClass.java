package info.esoft.pizza.helpers;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketExtension;
import com.neovisionaries.ws.client.WebSocketFactory;
import info.esoft.pizza.constants.Const;

public final class AuthorizationClass implements Const {

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
                .setConnectionTimeout(ServiceSmsCode.TIMEOUT)
                .createSocket(ServiceSmsCode.SYTE_GET_SMS_CODE)
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