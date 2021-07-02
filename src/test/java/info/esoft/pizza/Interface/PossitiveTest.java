package info.esoft.pizza.Interface;

import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    @DisplayName("Пункт 'Наборы' присутствует в меню")
    @Test
    public void menuIsHaveSetTest(){
        MainPage page = new MainPage(driver);
        page = page.closeModalWindow();
        Assert.assertTrue(page.menuIsHaveSet());
    }

    @DisplayName("Наборы присутствуют как блок элементов на сайте")
    @Test
    public void menuIsHaveSetsBlockTest(){
        MainPage page = new MainPage(driver);
        page = page.closeModalWindow();
        Assert.assertTrue(page.menuIsHaveSetsBlock());
    }
}
