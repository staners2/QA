package info.esoft;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class PizzaUiTest {

    public WebDriver driver;
    public final String stringWebSyte = "https://пиццуля42.рф";

    @Before
    public void Up(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void Close() {
        driver.quit();
    }

    @Test
    public void syteIsWorkedTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, false);
        Assert.assertTrue(driver.getTitle().contains("Доставка пиццы в Кемерово - Пиццуля"));
    }

    @Test
    public void menuIsHaveSetTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, false);
        WebElement linkSetInMenu = driver.findElement(By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[1]/div/div/div/div/a[3]"));
        Assert.assertTrue(linkSetInMenu.getText().contains("Наборы"));
    }

    @Test
    public void isHaveBlockSetTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, false);
        WebElement divSets = driver.findElement(By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]"));
        Assert.assertNotNull(divSets);
    }

    @Test
    public void priceEqualsWhenViewedAndPurchasedTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, false);
        String titleWhenView = driver.findElement(By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]/span[1]/a/span/span[2]/span[1]")).getText();
        String descriptionWhenView = driver.findElement(By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]/span[1]/a/span/span[2]/span[2]")).getText();

        SetFiftyOnFiftyPage setPage = new SetFiftyOnFiftyPage();
        driver = setPage.openSetFiftyOnFifty(driver);
        String titleWhenPurchase = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[1]/h1")).getText();
        String descriptionWhenPurchase = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div")).getText();

        boolean result = titleWhenView.equals(titleWhenPurchase) && descriptionWhenView.equals(descriptionWhenPurchase);
        Assert.assertTrue(result);
    }

    @Test
    public void addOnePizzaWhenPurchasedSetTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, false);

        SetFiftyOnFiftyPage setPage = new SetFiftyOnFiftyPage();
        driver = setPage.openSetFiftyOnFifty(driver);
        driver = setPage.addPizzaOne(driver);

        Assert.assertTrue(setPage.buttonBuyIsActive(driver));
    }

    @Test
    public void addTwoPizzaWhenPurchasedSetTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte,false);

        SetFiftyOnFiftyPage setPage = new SetFiftyOnFiftyPage();
        driver = setPage.openSetFiftyOnFifty(driver);
        driver = setPage.addPizzaOne(driver);
        driver = setPage.addPizzaTwo(driver);

        Assert.assertTrue(setPage.buttonBuyIsActive(driver));
    }

    // TODO FIX
    @Test
    public void addTwoPizzaAndSetWhenPurchasedTest(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, false);

        SetFiftyOnFiftyPage setPage = new SetFiftyOnFiftyPage();
        driver = setPage.openSetFiftyOnFifty(driver);
        driver = setPage.addPizzaOne(driver);
        driver = setPage.addPizzaTwo(driver);
        driver = setPage.addSet(driver);

        Assert.assertTrue(setPage.buttonBuyIsActive(driver));
    }

    // Реализовать авторизацию с подтягиванием Cookies
    @Test
    public void removeProductFromBasket(){
        MainPage page = new MainPage();
        driver = page.OpenSyte(driver, stringWebSyte, true);

        SetFiftyOnFiftyPage setPage = new SetFiftyOnFiftyPage();
        driver = setPage.buySetFiftyOnFifty(driver);
        driver = setPage.closePage(driver);

        BasketPage basketPage = new BasketPage();
        basketPage.openPage(driver);


    }
}
