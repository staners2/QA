package info.esoft.pizza.helpers;

public class Helpers {

    public static String getCodeAuthorization() throws Exception {
        AuthorizationClass.start();
        return AuthorizationClass.totalCode;
    }

}
