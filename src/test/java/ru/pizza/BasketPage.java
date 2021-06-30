package ru.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private final WebDriver driver;
    String expectedDescription = "В вашей корзине нет ни одного товара";
    By linkRemoveSet = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div[2]/a[1]");
    By linkRemovePepsi = By.xpath("");

    By linkCloseWindow = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/a");
    By textDescriptionBasket = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div/div/div/i");
    By textPriceOrder = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div/b/span");

    By inputName = By.id("cart-name");
    By selectListAddress = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[2]/div[2]/div/span/a");
    By selectAddress = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div/a[1]");
    By inputStreet = By.id("cart-street");
    By inputHouse = By.id("cart-house");
    By inputAppartment = By.id("cart-appartment");
    By inputPromocode = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[3]/div[2]/div[1]/input");
    By linkAcceptPromocode = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[3]/div[2]/div[1]/a");
    By linkBuyOrder = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div[3]/a");

    By conditionOne = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div[3]/div[1]/a");
    By conditionTwo = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div[3]/div[2]/a");

    String name = "test";
    String street = "test";
    String house = "test";
    String appartament = "test";
    String promocode = "test";

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public BasketPage removeSet(){
        driver.findElement(linkRemoveSet).click();
        return this;
    }

    public BasketPage removePepsi(){
        driver.findElement(linkRemovePepsi).click();
        return this;
    }

    public MainPage closeWindow(){
        driver.findElement(linkCloseWindow).click();
        return new MainPage(driver);
    }

    public boolean isEqualsDescription(){
        return driver.findElement(textDescriptionBasket).getText().equals(expectedDescription);
    }

    public String getPriceOrder(){
        String price = driver.findElement(textPriceOrder).getText();
        price = price.substring(0, price.length() - 5);
        return price;
    }

    public BasketPage sendName(){
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    public BasketPage selectAddress(){
        driver.findElement(selectListAddress).click();
        driver.findElement(selectAddress).click();
        return this;
    }

    public BasketPage sendStreet(){
        driver.findElement(inputStreet).sendKeys(street);
        return this;
    }

    public BasketPage sendHouse(){
        driver.findElement(inputHouse).sendKeys(house);
        return this;
    }

    public BasketPage sendAppartment(){
        driver.findElement(inputAppartment).sendKeys(appartament);
        return this;
    }

    public BasketPage sendPromocode(){
        driver.findElement(inputPromocode).sendKeys(promocode);
        return this;
    }

    public BasketPage acceptConditionOne(){
        driver.findElement(conditionOne).click();
        return this;
    }

    public BasketPage acceptConditionTwo(){
        driver.findElement(conditionTwo).click();
        return this;
    }

    public boolean buttonBuyOrderIsActive(){
        return driver.findElement(linkBuyOrder) != null;
    }
}
