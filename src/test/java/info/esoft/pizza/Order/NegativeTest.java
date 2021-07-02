package info.esoft.pizza.Order;

import info.esoft.pizza.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NegativeTest extends Driver {

    // TODO Проверить
    @Test
    @DisplayName("Оформление заказа с не введенными данными")
    public void formAnOrderWithNoCorrectData() throws Exception {
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

        Assert.assertTrue(basketPage.isButtonBuyOrderActive());
    }

    // TODO Проверить
    @Test
    @DisplayName("Ввод не корректного промокода")
    public void formAnOrderWithNoCorrectPromocode() throws Exception {
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

        basketPage = basketPage.sendPromocode();

        Assert.assertTrue(basketPage.isPromocodeCorrect());
    }
}
