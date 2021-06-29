package info.esoft;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class UiTest {

    WebDriver driver;

    @Before
    public void Up(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void Close() {
        driver.quit();
    }

    @Test
    public void substractTwoNumbersTest(){
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement formElement = driver.findElement(By.id("calcForm"));
        Actions action = new Actions(driver).moveToElement(formElement);

        selectBuild("0");

        fieldSendTextInFirst("1");
        fieldSendTextInSecond("2");

        selectOperations("1");

        WebElement buttonCalculate = driver.findElement(By.id("calculateButton"));
        buttonCalculate.click();

        WebElement fieldAnswer = driver.findElement(By.id("numberAnswerField"));
        Assert.assertEquals("-1", fieldAnswer.getAttribute("value"));

    }

    @Test
    public void concatenateTwoWordsTest(){
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement formElement = driver.findElement(By.id("calcForm"));
        Actions action = new Actions(driver).moveToElement(formElement);

        selectBuild("0");

        fieldSendTextInFirst("gs");
        fieldSendTextInSecond("bu");

        selectOperations("4");

        WebElement buttonCalculate = driver.findElement(By.id("calculateButton"));
        buttonCalculate.click();

        WebElement fieldAnswer = driver.findElement(By.id("numberAnswerField"));
        Assert.assertEquals("gsbu", fieldAnswer.getAttribute("value"));
    }

    @Test
    public void buildTest(){
        driver.get("https://testsheepnz.github.io/random-number.html");

        WebElement formElement = driver.findElement(By.id("buildNumber"));
        Actions action = new Actions(driver).moveToElement(formElement);

        WebElement selectBuild = driver.findElement(By.id("buildNumber"));
        Select selectList = new Select(selectBuild);
        selectList.selectByValue("0");

        WebElement buttonRolle = driver.findElement(By.id("rollDiceButton"));
        buttonRolle.click();

        WebElement fieldInputNumber = driver.findElement(By.id("numberGuess"));
        fieldInputNumber.sendKeys("string");

        WebElement buttonSubmit = driver.findElement(By.id("submitButton"));
        buttonSubmit.click();

        WebElement fieldAnswer = driver.findElement(By.id("feedbackLabel"));
        String answerText = fieldAnswer.findElement(By.tagName("i")).getText();

        Assert.assertEquals("string: Not a number!", answerText);
    }

    public void fieldSendTextInFirst(String input){
        WebElement fieldFirstNumber = driver.findElement(By.id("number1Field"));
        fieldFirstNumber.sendKeys(input);
    }

    public void fieldSendTextInSecond(String input){
        WebElement fieldFirstNumber = driver.findElement(By.id("number2Field"));
        fieldFirstNumber.sendKeys(input);
    }

    public void selectBuild(String inputValue){
        WebElement selectBuild = driver.findElement(By.id("selectBuild"));
        Select selectList = new Select(selectBuild);
        selectList.selectByValue(inputValue);
    }

    public void selectOperations(String inputValue){
        WebElement selectOperation = driver.findElement(By.id("selectOperationDropdown"));
        Select operationList = new Select(selectOperation);
        operationList.selectByValue(inputValue);
    }
}
