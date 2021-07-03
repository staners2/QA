package info.esoft.pizza.SyteWorked;

import info.esoft.pizza.Driver;
import info.esoft.pizza.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    @DisplayName("Открытие сайта")
    @Test
    public void syteIsWorkedTest(){
        MainPage page = new MainPage(driver);
        Assert.assertTrue(page.getTitleSyte().contains("Доставка пиццы в Кемерово - Пиццуля"));
    }
}
