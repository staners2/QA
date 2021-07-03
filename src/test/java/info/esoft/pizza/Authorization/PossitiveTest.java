package info.esoft.pizza.Authorization;

import info.esoft.pizza.constants.TestUser;
import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.AuthorizationPage;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    @Test
    @DisplayName("Согласится со всеми условиями и ввести корректный номер телефона")
    public void acceptPropaganationAndProcessing(){
        MainPage mainPage = new MainPage();
        mainPage.closeModalWindow();
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage.sendNumber(TestUser.NUMBER);
        authPage.acceptConditionOne();
        authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }
}
