package info.esoft.pizza.SyteWorked;

import info.esoft.pizza.constants.Const;
import info.esoft.pizza.helpers.Driver;
import info.esoft.pizza.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class PossitiveTest extends Driver {

    @DisplayName("Открытие сайта")
    @Test
    public void syteIsWorkedTest(){
        MainPage page = new MainPage();
        Assert.assertTrue(page.getTitleSyte().contains(SyteInfo.TITLE_SYTE));
    }
}
