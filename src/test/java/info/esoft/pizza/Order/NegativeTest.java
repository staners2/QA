package info.esoft.pizza.Order;

import info.esoft.pizza.constants.TestUser;
import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.AuthorizationPage;
import info.esoft.pizza.pages.BasketPage;
import info.esoft.pizza.pages.FiftyOnFiftyPage;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NegativeTest extends Driver {

    // TODO Проверить
    @Test
    @DisplayName("Оформление заказа с не введенными данными")
    public void formAnOrderWithNoCorrectData() throws Exception {
        MainPage mainPage = new MainPage();
        mainPage.closeModalWindow();

        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        mainPage = authPage.authorization();

        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage.addPizzaOne();
        fiftyPage.addPizzaTwo();
        fiftyPage.addSet();
        fiftyPage.buySet();

        mainPage = fiftyPage.closeModalWindow();
        BasketPage basketPage = mainPage.openBasket();

        Assert.assertTrue(basketPage.isButtonBuyOrderActive());
    }

    // TODO Проверить
    @Test
    @DisplayName("Ввод не корректного промокода")
    public void formAnOrderWithNoCorrectPromocode() throws Exception {
        MainPage mainPage = new MainPage();
        mainPage.closeModalWindow();

        AuthorizationPage authPage = mainPage.openAuthorizationWindow();
        mainPage = authPage.authorization();

        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage.addPizzaOne();
        fiftyPage.addPizzaTwo();
        fiftyPage.addSet();
        fiftyPage.buySet();

        mainPage = fiftyPage.closeModalWindow();
        BasketPage basketPage = mainPage.openBasket();

        basketPage.sendName(TestUser.NAME);
        basketPage.selectAddress();
        basketPage.sendStreet(TestUser.STREET);
        basketPage.sendHouse(TestUser.HOUSE);
        basketPage.sendAppartment(TestUser.APPARTAMENT);

        basketPage.sendPromocode(TestUser.PROMOCODE_ERROR);

        Assert.assertTrue(basketPage.isPromocodeCorrect());
    }
}
