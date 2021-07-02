package info.esoft.pizza.Order;

import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.AuthorizationPage;
import info.esoft.pizza.pages.BasketPage;
import info.esoft.pizza.pages.FiftyOnFiftyPage;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    // TODO Проверить
    @Test
    @DisplayName("Оформление заказа с корректно введенными данными")
    public void formAnOrderWithCorrectData() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();

        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        mainPage = authPage.authorization();

        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();
        fiftyPage = fiftyPage.addPizzaTwo();
        fiftyPage = fiftyPage.addSet();
        fiftyPage = fiftyPage.buySet();

        mainPage = fiftyPage.closeModalWindow();
        BasketPage basketPage = mainPage.openBasket();

        basketPage = basketPage.sendName();
        basketPage = basketPage.selectAddress();
        basketPage = basketPage.sendStreet();
        basketPage = basketPage.sendHouse();
        basketPage = basketPage.sendAppartment();

        Assert.assertTrue(basketPage.isButtonBuyOrderActive());
    }
}
