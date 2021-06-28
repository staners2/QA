package info.esoft;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SetFiftyOnFiftyPage {

    public WebDriver openSetFiftyOnFifty(WebDriver driver){
        WebElement linkBlockSet = driver.findElement(By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]/span[1]/a/span/span[3]/span[2]/span"));
        linkBlockSet.click();
        return driver;
    }

    public WebDriver addSet(WebDriver driver){
        WebElement buttonAddSet = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div/span"));
        buttonAddSet.click();
        return null;
    }

    public WebDriver addPizzaOne(WebDriver driver){
        WebElement buttonAddPizza = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div/span"));
        buttonAddPizza.click();
        return driver;
    }

    public WebDriver addPizzaTwo(WebDriver driver){
        WebElement buttonAddPizza = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/span"));
        buttonAddPizza.click();
        return driver;
    }

    public boolean buttonBuyIsActive(WebDriver driver){
        WebElement buttonBuy = driver.findElement(By.className("button-disabled"));
        return buttonBuy != null;
    }

    public WebDriver buySetFiftyOnFifty(WebDriver driver){
        SetFiftyOnFiftyPage setPage = new SetFiftyOnFiftyPage();
        setPage.openSetFiftyOnFifty(driver);
        driver = setPage.addPizzaOne(driver);
        driver = setPage.addPizzaTwo(driver);
        driver = setPage.addSet(driver);

        WebElement buttonBuy = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/a"));
        buttonBuy.click();

        return driver;
    }

    // Close window set 50/50
    public WebDriver closePage(WebDriver driver){
        WebElement buttonClose = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/a"));
        buttonClose.click();
        return driver;
    }
}
