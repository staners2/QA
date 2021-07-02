package info.esoft.pizza.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private final WebDriver driver;
    String expectedDescription = "В вашей корзине нет ни одного товара";
    String textPromocodeError = "Промокод не корректен. Проверьте информацию об акции и попробуйте еще раз!";
    By linkRemoveSet = By.xpath("//div[@class='cart-receipt'] //div[@class='cart-product'] //a");
    By linkRemovePepsi = By.xpath("//div[@class='cart-receipt'] //div[@class='cart-product'] //a");

    By linkCloseWindow = By.xpath("//a[@class='modal-dialog-close']");
    By textDescriptionBasket = By.xpath("//div[@class='container-fluid'] //div[@class='row']//div/i");
    By textPriceOrder = By.xpath("//div[@class='cart-receipt-total-value'] //span");

    By inputName = By.xpath("//input[@id='cart-name']");
    By selectListAddress = By.xpath("//div[@class='cr-dlv-form-container active-form'] //a[@class='form-control form-control-selector-link']");
    By selectAddress = By.xpath("//div[@class='cart-sub-dialog cart-receipts-dialog in modal'] //div[@class='modal-dialog'] //a");
    By inputStreet = By.id("cart-street");
    By inputHouse = By.id("cart-house");
    By inputAppartment = By.id("cart-appartment");
    By inputPromocode = By.xpath("//input[@class='form-control promo-manual']");
    By linkAcceptPromocode = By.xpath("//a[@class='promo-manual-apply button-solid button-md']");
    By divErrorPromocode = By.xpath("//div[@class='promocode-status-message promocode-red']");
    By linkBuyOrder = By.xpath("//form/div[last()]/a");

    By conditionOne = By.xpath("//div[@class='license-agreement-container'][1]/a");
    By conditionTwo = By.xpath("//div[@class='license-agreement-container'][2]/a");

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

    public boolean isButtonBuyOrderActive(){
        return !driver.findElement(linkBuyOrder).getAttribute("class").contains("button-disabled");
    }

    public boolean isPromocodeCorrect(){
        return !driver.findElement(divErrorPromocode).getText().contains(textPromocodeError);
    }

}
