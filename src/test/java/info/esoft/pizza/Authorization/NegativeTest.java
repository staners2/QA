package info.esoft.pizza.Authorization;

import info.esoft.pizza.AuthorizationPage;
import info.esoft.pizza.Driver;
import info.esoft.pizza.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NegativeTest extends Driver {
    @Test
    @DisplayName("Ввод букв в поле для ввода номера")
    public void inputOnlyLettersTest(){
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage = authPage.sendNumber("asdasfasf");
        authPage = authPage.acceptConditionOne();
        authPage = authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }

    @Test
    @DisplayName("Ввод неверного кода региона")
    public void inputIncorrectCodeRegionTest(){
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage = authPage.sendNumber("19516085864");
        authPage = authPage.acceptConditionOne();
        authPage = authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }

    @Test
    @DisplayName("Не согласится с обработкой персональных данных")
    public void noAcceptProcessingPersonalDataTest(){
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage = authPage.sendNumber("89516085864");
        authPage = authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }

    @Test
    @DisplayName("Не согласится с условиями распространения персональных данных")
    public void noAcceptPropaganation(){
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage = authPage.sendNumber("89516085864");
        authPage = authPage.acceptConditionOne();
        Assert.assertTrue(authPage.isButtonSendActive());
    }
}
