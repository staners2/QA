package info.esoft.pizza.Basket;

import info.esoft.pizza.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    // TODO Проверить
    // @Test
    @DisplayName("Удаление всех товаров из корзины при оформлении заказа")
    public void removedAllProductsFromBasketTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();

        // TODO Make authorization

        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();
        fiftyPage = fiftyPage.addPizzaTwo();
        fiftyPage = fiftyPage.addSet();
        fiftyPage = fiftyPage.buySet();

        mainPage = fiftyPage.closeModalWindow();
        BasketPage basketPage = mainPage.openBasket();
        basketPage = basketPage.removeSet();
        Assert.assertTrue(basketPage.isEqualsDescription());
    }

    // TODO Проверить
    @Test
    @DisplayName("Добавление товара в корзину при нескольких переходах в корзину")
    public void addProductInBasketAndExitBasketTest() throws Exception {
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

        mainPage = basketPage.closeWindow();

        mainPage = mainPage.openMenuBuyPepsi();
        mainPage = mainPage.buyPepsi();
        mainPage = mainPage.upCountPepsi();
        mainPage = mainPage.closePepsiWindow();

        basketPage = mainPage.openBasket();
        String price = basketPage.getPriceOrder();
        Assert.assertTrue(price.equals("1080"));
    }

    // TODO Проверить
    // @Test
    @DisplayName("Удаление одного товара из корзины")
    public void removeOneProductFromBasketTest() throws Exception {
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

        mainPage = basketPage.closeWindow();

        mainPage = mainPage.buyPepsi();
        mainPage = mainPage.upCountPepsi();
        mainPage = mainPage.closePepsiWindow();

        basketPage = mainPage.openBasket();
        basketPage = basketPage.removePepsi();
        String price = basketPage.getPriceOrder();
        Assert.assertTrue(price.equals("880"));
    }
}
