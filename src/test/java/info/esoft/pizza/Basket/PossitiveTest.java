package info.esoft.pizza.Basket;

import info.esoft.pizza.constants.TestOrder;
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
    @DisplayName("Удаление всех товаров из корзины при оформлении заказа")
    public void removedAllProductsFromBasketTest() throws Exception {
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
        basketPage.removeSet();
        Assert.assertTrue(basketPage.isEqualsDescription());
    }

    // TODO Проверить
    @Test
    @DisplayName("Добавление товара в корзину при нескольких переходах в корзину")
    public void addProductInBasketAndExitBasketTest() throws Exception {
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

        mainPage = basketPage.closeWindow();

        mainPage.openMenuBuyPepsi();
        mainPage.buyPepsi();
        mainPage.upCountPepsi();
        mainPage.closePepsiWindow();

        basketPage = mainPage.openBasket();
        String price = basketPage.getPriceOrder();
        Assert.assertTrue(price.equals(TestOrder.PRICE_ONE_SET_AND_TWO_PEPSI));
    }

    // TODO Проверить
    // @Test
    @DisplayName("Удаление одного товара из корзины")
    public void removeOneProductFromBasketTest() throws Exception {
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

        mainPage = basketPage.closeWindow();

        mainPage.buyPepsi();
        mainPage.upCountPepsi();
        mainPage.closePepsiWindow();

        basketPage = mainPage.openBasket();
        basketPage.removePepsi();
        String price = basketPage.getPriceOrder();
        Assert.assertTrue(price.equals(TestOrder.PRICE_ONE_SET_AND_ONE_PEPSI));
    }
}
