package info.esoft.pizza.pages;

import com.codeborne.selenide.SelenideElement;
import info.esoft.pizza.constants.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FiftyOnFiftyPage {

    SelenideElement linkCloseModalWindow = $x("//a[@class='modal-dialog-close']");
    SelenideElement linkSet = $x("//div[@class='constructor-step'][1] //span[@class='variant-add-button button-empty button-micro']");
    SelenideElement linkPizzaOne = $x("//div[@class='constructor-step'][1] //div[1] //span[@class='variant-add-button button-empty button-micro']");
    SelenideElement linkPizzaTwo = $x("//div[@class='constructor-step'][2] //div[2] //span[@class='variant-add-button button-empty button-micro']");
    SelenideElement linkBuy = $x("//div[@class='product-full-cart-buy-container'] //a");
    SelenideElement textTitleSet = $x("//h1[@class='product-full-cart-name']");
    SelenideElement textSubtitleSet = $x("//div[@class='product-full-cart-description']");

    public FiftyOnFiftyPage() {

    }

    public MainPage closeModalWindow(){
        linkCloseModalWindow.click();
        return new MainPage();
    }

    public void addSet(){
        linkSet.click();
    }

    public void addPizzaOne(){
        linkPizzaOne.click();
    }

    public void addPizzaTwo(){
        linkPizzaTwo.click();
    }

    public void buySet(){
        linkBuy.click();
    }

    public boolean isButtonBuyActive(){
        return !linkBuy.getAttribute("class").contains(Const.ClassButton.BUTTON_DISABLED);
    }

    public String getTitleSet(){
        return textTitleSet.getText();
    }

    public String getSubtitleSet(){
        return textSubtitleSet.getText();
    }
}
