package info.esoft.pizza.Authorization;

import info.esoft.pizza.pages.AuthorizationPage;
import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    @Test
    @DisplayName("Согласится со всеми условиями и ввести корректный номер телефона")
    public void acceptPropaganationAndProcessing(){
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage = authPage.sendNumber("89516085864");
        authPage = authPage.acceptConditionOne();
        authPage = authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }
}
