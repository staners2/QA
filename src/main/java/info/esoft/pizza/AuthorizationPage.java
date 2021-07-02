package info.esoft.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage {
    public WebDriver driver;

    private By inputNumber = By.xpath("//div[@class='sp-input-container'] //input");
    private By linkSendNumber = By.xpath("//div[@class='sp-input-container'] //a");
    private By inputCode = By.xpath("//div[@class='phone-code-container'] //input");
    private By linkSendCode = By.xpath("//div[@class='phone-code-container'] //a");
    private By conditionOne = By.xpath("//div[@class='setup-phone-container'] //div[@class='license-agreement-container'][1] //a");
    private By conditionTwo = By.xpath("//div[@class='setup-phone-container'] //div[@class='license-agreement-container'][2] //a");

    private String number = "79234851589";

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage authorization() throws Exception {
        sendNumber(number);
        acceptConditionOne();
        acceptConditionTwo();
        submitNumber();
        String code = getCodeAuthorization();
        sendCode(code);
        return new MainPage(driver);
    }

    private String getCodeAuthorization() throws Exception {
        AuthorizationClass.start();
        return AuthorizationClass.totalCode;
    }

    public AuthorizationPage sendNumber(String inputText){
        WebElement elem = driver.findElement(inputNumber);
        elem.sendKeys(Keys.BACK_SPACE);
        elem.sendKeys(inputText);
        return this;
    }

    public AuthorizationPage sendCode (String code) throws InterruptedException {
        driver.findElement(inputCode).sendKeys(code);
        Thread.sleep(3000);
        driver.findElement(linkSendCode).click();
        return this;
    }

    public AuthorizationPage acceptConditionOne(){
        driver.findElement(conditionOne).click();
        return this;
    }

    public AuthorizationPage acceptConditionTwo(){
        driver.findElement(conditionTwo).click();
        return this;
    }

    public void submitNumber(){
        driver.findElement(linkSendNumber).click();
    }

    public boolean isButtonSendActive(){
        return !driver.findElement(linkSendNumber).getAttribute("class").contains("button-disabled");
    }
}
