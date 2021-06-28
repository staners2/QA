package info.esoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {

    public WebDriver openPage(WebDriver driver){
        WebElement linkBasket = driver.findElement(By.xpath("//*[@id=\'appContainer\']/div/div[1]/div[1]/div/span[2]/a[1]"));
        linkBasket.click();

        return driver;
    }
}
