package info.esoft.pizza.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import info.esoft.pizza.constants.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPage {

    SelenideElement linkCloseModalWindow = $x("//a[@class='modal-dialog-close']");
    SelenideElement linkBlockSet = $x("//div[@name='2256682442'] //a");
    SelenideElement divSetsBlock = $x("//div[@name='2256682442']");
    SelenideElement linkSetInMenu = $x("//div[@class='simple-tagsbar-body'] //a[3]");
    SelenideElement textTitleSet = $x("//div[@name='2256682442'] //span[@class='product-cart-name']");
    SelenideElement textSubtitleSet = $x("//div[@name='2256682442'] //span[@class='product-cart-comment']");
    SelenideElement linkBasket = $x("//span[@class='header-top-right'] //i");
    SelenideElement linkPepsiCard = $x("//div[@name='2256682511'] //a");
    SelenideElement linkBuyPepsi = $x("//div[@class='product-full-cart-buy-container'] //a");
    SelenideElement linkUpCountPepsi = $x("//div[@class='product-count-change-buttons-container'] //a[2]");
    SelenideElement linkClosePepsiWindow = $x("//a[@class='modal-dialog-close']");
    SelenideElement linkMyAccount = $x("//span[@class='header-top-right'] //a[contains(text(), 'Мой аккаунт')]");
    SelenideElement linkClosePhoneWidget = $x("//span[@class='fm-close-button']");

    public MainPage(){

    }

    public AuthorizationPage openAuthorizationWindow(){
        linkMyAccount.click();
        return new AuthorizationPage();
    }

    public void closeModalWindow(){
        linkCloseModalWindow.click();
        linkClosePhoneWidget.click();
    }

    public FiftyOnFiftyPage openFiftyOnFiftySet(){
        linkBlockSet.click();
        return new FiftyOnFiftyPage();
    }

    public void openMenuBuyPepsi(){
        linkPepsiCard.click();
    }

    public void buyPepsi(){
        linkBuyPepsi.click();
    }

    public void upCountPepsi(){
        linkUpCountPepsi.click();
    }

    public void closePepsiWindow(){
        linkClosePepsiWindow.click();
    }

    public BasketPage openBasket(){
        linkBasket.click();
        return new BasketPage();
    }

    public String getTitleSyte(){
        // TODO Вернуть название сайта | Сделать
        return title();
    }

    public boolean menuIsHaveSet(){
        return linkSetInMenu.getText().contains("Наборы");
    }

    public boolean menuIsHaveSetsBlock(){
        return divSetsBlock != null;
    }

    public String getTitleSet(){
        return textTitleSet.getText();
    }

    public String getSubtitleSet(){
        return textSubtitleSet.getText();
    }
}
