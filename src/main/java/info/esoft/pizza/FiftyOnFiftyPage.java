package info.esoft.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiftyOnFiftyPage {
    private WebDriver driver;

    By linkCloseModalWindow = By.xpath("//a[@class='modal-dialog-close']");
    By linkSet = By.xpath("//div[@class='constructor-step'][1] //span[@class='variant-add-button button-empty button-micro']");
    By linkPizzaOne = By.xpath("//div[@class='constructor-step'][1] //div[1] //span[@class='variant-add-button button-empty button-micro']");
    By linkPizzaTwo = By.xpath("//div[@class='constructor-step'][2] //div[2] //span[@class='variant-add-button button-empty button-micro']");
    By linkBuy = By.xpath("//div[@class='product-full-cart-buy-container'] //a");
    By textTitleSet = By.xpath("//h1[@class='product-full-cart-name']");
    By textSubtitleSet = By.xpath("//div[@class='product-full-cart-description']");

    public FiftyOnFiftyPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage closeModalWindow(){
        driver.findElement(linkCloseModalWindow).click();
        return new MainPage(driver);
    }

    public FiftyOnFiftyPage addSet(){
        driver.findElement(linkSet).click();
        return this;
    }

    public FiftyOnFiftyPage addPizzaOne(){
        driver.findElement(linkPizzaOne).click();
        return this;
    }

    public FiftyOnFiftyPage addPizzaTwo(){
        driver.findElement(linkPizzaTwo).click();
        return this;
    }

    public FiftyOnFiftyPage buySet(){
        driver.findElement(linkBuy).click();
        return this;
    }

    public boolean isButtonBuyActive(){
        return !driver.findElement(linkBuy).getAttribute("class").contains("button-disabled");
    }

    public String getTitleSet(){
        return driver.findElement(textTitleSet).getText();
    }

    public String getSubtitleSet(){
        return driver.findElement(textSubtitleSet).getText();
    }
}
