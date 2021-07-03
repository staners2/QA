package info.esoft.pizza.Authorization;

import info.esoft.pizza.constants.TestUser;
import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.AuthorizationPage;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NegativeTest extends Driver {
    @Test
    @DisplayName("Ввод букв в поле для ввода номера")
    public void inputOnlyLettersTest(){
        MainPage mainPage = new MainPage();
        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage.sendNumber(TestUser.ERROR_NUMBER_LETTER);
        authPage.acceptConditionOne();
        authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }

    @Test
    @DisplayName("Ввод неверного кода региона")
    public void inputIncorrectCodeRegionTest(){
        MainPage mainPage = new MainPage();
        mainPage.closeModalWindow();

        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage.sendNumber(TestUser.ERROR_NUMBER_COUNTRY_CODE);
        authPage.acceptConditionOne();
        authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }

    @Test
    @DisplayName("Не согласится с обработкой персональных данных")
    public void noAcceptProcessingPersonalDataTest(){
        MainPage mainPage = new MainPage();
        mainPage.closeModalWindow();

        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage.sendNumber(TestUser.NUMBER);
        authPage.acceptConditionTwo();
        Assert.assertTrue(authPage.isButtonSendActive());
    }

    @Test
    @DisplayName("Не согласится с условиями распространения персональных данных")
    public void noAcceptPropaganation(){
        MainPage mainPage = new MainPage();
        mainPage.closeModalWindow();

        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        authPage.sendNumber(TestUser.NUMBER);
        authPage.acceptConditionOne();
        Assert.assertTrue(authPage.isButtonSendActive());
    }
}
