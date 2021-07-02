package info.esoft.pizza.pages;

import com.codeborne.selenide.SelenideElement;
import info.esoft.pizza.constants.Const;
import info.esoft.pizza.constants.TestUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BasketPage {

    SelenideElement linkRemoveSet = $x("//div[@class='cart-receipt'] //div[@class='cart-product'] //a");
    SelenideElement linkRemovePepsi = $x("//div[@class='cart-receipt'] //div[@class='cart-product'] //a");

    SelenideElement linkCloseWindow = $x("//a[@class='modal-dialog-close']");
    SelenideElement textDescriptionBasket = $x("//div[@class='container-fluid'] //div[@class='row']//div/i");
    SelenideElement textPriceOrder = $x("//div[@class='cart-receipt-total-value'] //span");

    SelenideElement inputName = $x("//input[@id='cart-name']");
    SelenideElement selectListAddress = $x("//div[@class='cr-dlv-form-container active-form'] //a[@class='form-control form-control-selector-link']");
    SelenideElement selectAddress = $x("//div[@class='cart-sub-dialog cart-receipts-dialog in modal'] //div[@class='modal-dialog'] //a");
    SelenideElement inputStreet = $("#cart-street");
    SelenideElement inputHouse = $("#cart-house");
    SelenideElement inputAppartment = $("#cart-appartment");
    SelenideElement inputPromocode = $x("//input[@class='form-control promo-manual']");
    SelenideElement linkAcceptPromocode = $x("//a[@class='promo-manual-apply button-solid button-md']");
    SelenideElement divErrorPromocode = $x("//div[@class='promocode-status-message promocode-red']");
    SelenideElement linkBuyOrder = $x("//form/div[last()]/a");

    SelenideElement conditionOne = $x("//div[@class='license-agreement-container'][1]/a");
    SelenideElement conditionTwo = $x("//div[@class='license-agreement-container'][2]/a");

    public BasketPage() {

    }

    public void removeSet(){
        linkRemoveSet.click();
    }

    public void removePepsi(){
        linkRemovePepsi.click();
    }

    public MainPage closeWindow(){
        linkCloseWindow.click();
        return new MainPage();
    }

    public boolean isEqualsDescription(){
        return textDescriptionBasket.getText().equals(Const.Errors.BASKET_EMPTY);
    }

    public String getPriceOrder(){
        String price = textPriceOrder.getText();
        price = price.substring(0, price.length() - 5);
        return price;
    }

    public void sendName(String name){
        inputName.sendKeys(name);
    }

    public void selectAddress(){
        selectListAddress.click();
        selectAddress.click();
    }

    public void sendStreet(String street){
        inputStreet.sendKeys(street);
    }

    public void sendHouse(String house){
        inputHouse.sendKeys(house);
    }

    public void sendAppartment(String appartament){
        inputAppartment.sendKeys(appartament);
    }

    public void sendPromocode(String promocode){
        inputPromocode.sendKeys(promocode);
    }

    public void acceptConditionOne(){
        conditionOne.click();
    }

    public void acceptConditionTwo(){
        conditionTwo.click();
    }

    public boolean isButtonBuyOrderActive(){
        return !linkBuyOrder.getAttribute("class").contains(Const.ClassButton.BUTTON_DISABLED);
    }

    public boolean isPromocodeCorrect(){
        return !divErrorPromocode.getText().contains(Const.Errors.PROMOCODE_ERROR);
    }

}
