package info.esoft.pizza.BuySet;

import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.FiftyOnFiftyPage;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NegativeTest extends Driver {

    @Test
    @DisplayName("Стадия выбора 'Набора', выбрав только одну пиццу")
    public void addOnePizzaWhenPurchasedSetTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();

        Assert.assertTrue(fiftyPage.isButtonBuyActive());
    }

    @Test
    @DisplayName("Стадия выбора 'Набора', выбрав только две пиццы")
    public void addTwoPizzaWhenPurchasedSetTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();
        fiftyPage = fiftyPage.addPizzaTwo();

        Assert.assertTrue(fiftyPage.isButtonBuyActive());
    }
}
