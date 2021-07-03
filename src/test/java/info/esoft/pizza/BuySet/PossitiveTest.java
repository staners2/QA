package info.esoft.pizza.BuySet;

import info.esoft.pizza.Driver;
import info.esoft.pizza.FiftyOnFiftyPage;
import info.esoft.pizza.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    @DisplayName("Совпадение информации о товаре при просмотре и приобретении")
    @Test
    public void priceEqualsWhenViewedAndPurchasedTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        String titleView = mainPage.getTitleSet();
        String subtitleView = mainPage.getSubtitleSet();

        FiftyOnFiftyPage fiftyPage =  mainPage.openFiftyOnFiftySet();
        String titlePurchase = fiftyPage.getTitleSet();
        String subtitlePurchase = fiftyPage.getSubtitleSet();

        boolean result = titleView.equals(titlePurchase) && subtitleView.equals(subtitlePurchase);
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Стадия выбора 'Набора', выбрав только две пиццы и набор")
    public void addTwoPizzaAndSetWhenPurchasedTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();
        fiftyPage = fiftyPage.addPizzaTwo();
        fiftyPage = fiftyPage.addSet();

        Assert.assertTrue(fiftyPage.isButtonBuyActive());
    }
}
