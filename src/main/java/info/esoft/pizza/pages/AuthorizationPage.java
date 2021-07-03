package info.esoft.pizza.pages;

import com.codeborne.selenide.SelenideElement;
import info.esoft.pizza.*;
import info.esoft.pizza.constants.TestUser;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

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
        System.out.println("Code: " + code);
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
        linkSendCode.click();
    }

    public void acceptConditionOne(){
        conditionOne.click();
    }

    public void acceptConditionTwo(){
        conditionTwo.click();
    }

    public void submitNumber() throws InterruptedException {
        Thread.sleep(1500);
        linkSendNumber.click();
        Thread.sleep(1500);
    }

    public boolean isButtonSendActive(){
        return !linkSendNumber.getAttribute("class").contains(Const.ClassButton.BUTTON_DISABLED);
    }
}
