package info.esoft.pizza.pages;

import com.codeborne.selenide.SelenideElement;
import info.esoft.pizza.constants.Const;
import info.esoft.pizza.constants.TestUser;
import info.esoft.pizza.helpers.AuthorizationClass;
import info.esoft.pizza.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AuthorizationPage {

    private SelenideElement inputNumber = $x("//div[@class='sp-input-container'] //input");
    private SelenideElement linkSendNumber = $x("//div[@class='sp-input-container'] //a");
    private SelenideElement inputCode = $x("//div[@class='phone-code-container'] //input");
    private SelenideElement linkSendCode = $x("//div[@class='phone-code-container'] //a");
    private SelenideElement conditionOne = $x("//div[@class='setup-phone-container'] //div[@class='license-agreement-container'][1] //a");
    private SelenideElement conditionTwo = $x("//div[@class='setup-phone-container'] //div[@class='license-agreement-container'][2] //a");

    public AuthorizationPage() {

    }

    public MainPage authorization() throws Exception {
        sendNumber(TestUser.NUMBER);
        acceptConditionOne();
        acceptConditionTwo();
        submitNumber();
        String code = Helpers.getCodeAuthorization();
        sendCode(code);

        MyAccountPage accountPage = new MyAccountPage();
        return accountPage.closeModalWindow();
    }

    public void sendNumber(String inputText){
        inputNumber.sendKeys(Keys.BACK_SPACE);
        inputNumber.sendKeys(inputText);
    }

    public void sendCode (String code) throws InterruptedException {
        inputCode.sendKeys(code);
        Thread.sleep(3000);
        linkSendCode.click();
    }

    public void acceptConditionOne(){
        conditionOne.click();
    }

    public void acceptConditionTwo(){
        conditionTwo.click();
    }

    public void submitNumber(){
        linkSendNumber.click();
    }

    public boolean isButtonSendActive(){
        return !linkSendNumber.getAttribute("class").contains(Const.ClassButton.BUTTON_DISABLED);
    }
}
