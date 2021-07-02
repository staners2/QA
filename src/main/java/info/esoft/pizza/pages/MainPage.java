package info.esoft.pizza.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    String nameSyte = "https://пиццуля42.рф";
    private WebDriver driver;

    By linkCloseModalWindow = By.xpath("//a[@class='modal-dialog-close']");
    By linkBlockSet = By.xpath("//div[@name='2256682442'] //a");
    By divSetsBlock = By.xpath("//div[@name='2256682442']");
    By linkSetInMenu = By.xpath("//div[@class='simple-tagsbar-body'] //a[3]");
    By textTitleSet = By.xpath("//div[@name='2256682442'] //span[@class='product-cart-name']");
    By textSubtitleSet = By.xpath("//div[@name='2256682442'] //span[@class='product-cart-comment']");
    By linkBasket = By.xpath("//span[@class='header-top-right'] //i");
    By linkPepsiCard = By.xpath("//div[@name='2256682511'] //a");
    By linkBuyPepsi = By.xpath("//div[@class='product-full-cart-buy-container'] //a");
    By linkUpCountPepsi = By.xpath("//div[@class='product-count-change-buttons-container'] //a[2]");
    By linkClosePepsiWindow = By.xpath("//a[@class='modal-dialog-close']");
    By linkMyAccount = By.xpath("//span[@class='header-top-right'] //a[contains(text(), 'Мой аккаунт')]");
    By linkClosePhoneWidget = By.xpath("//span[@class='fm-close-button']");

    public MainPage(WebDriver driver){
        driver.get(nameSyte);
        this.driver = driver;
    }

    public AuthorizationPage openAuthorizationWindow(){
        driver.findElement(linkMyAccount).click();
        return new AuthorizationPage(driver);
    }

    public MainPage closeModalWindow(){
        driver.findElement(linkCloseModalWindow).click();
        driver.findElement(linkClosePhoneWidget).click();
        return this;
    }

    public FiftyOnFiftyPage openFiftyOnFiftySet(){
        driver.findElement(linkBlockSet).click();
        return new FiftyOnFiftyPage(driver);
    }

    public MainPage openMenuBuyPepsi(){
        driver.findElement(linkPepsiCard).click();
        return this;
    }

    public MainPage buyPepsi(){
        driver.findElement(linkBuyPepsi).click();
        return this;
    }

    public MainPage upCountPepsi(){
        driver.findElement(linkUpCountPepsi).click();
        return this;
    }

    public MainPage closePepsiWindow(){
        driver.findElement(linkClosePepsiWindow).click();
        return this;
    }

    public BasketPage openBasket(){
        driver.findElement(linkBasket).click();
        return new BasketPage(driver);
    }

    public String getTitleSyte(){
        return driver.getTitle();
    }

    public boolean menuIsHaveSet(){
        return driver.findElement(linkSetInMenu).getText().contains("Наборы");
    }

    public boolean menuIsHaveSetsBlock(){
        return driver.findElement(divSetsBlock) != null;
    }

    public String getTitleSet(){
        return driver.findElement(textTitleSet).getText();
    }

    public String getSubtitleSet(){
        return driver.findElement(textSubtitleSet).getText();
    }
}
