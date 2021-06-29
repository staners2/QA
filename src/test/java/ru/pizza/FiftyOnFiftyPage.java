package ru.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiftyOnFiftyPage {
    private WebDriver driver;

    By linkCloseModalWindow = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/a");
    By buttonSet = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div/span");
    By buttonPizzaOne = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div/span");
    By buttonPizzaTwo = By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/span");
    By buttonBuy = By.className("button-disabled");
    By textTitleSet = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[1]/h1");
    By textSubtitleSet = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div");

    public FiftyOnFiftyPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage closeModalWindow(){
        driver.findElement(linkCloseModalWindow).click();
        return new MainPage(driver);
    }

    public FiftyOnFiftyPage addSet(){
        driver.findElement(buttonSet).click();
        return this;
    }

    public FiftyOnFiftyPage addPizzaOne(){
        driver.findElement(buttonPizzaOne).click();
        return this;
    }

    public FiftyOnFiftyPage addPizzaTwo(){
        driver.findElement(buttonPizzaTwo).click();
        return this;
    }

    public FiftyOnFiftyPage buySet(){
        driver.findElement(buttonBuy).click();
        return this;
    }

    // TODO Переделать
    public boolean buttonBuyIsActive(){
        return driver.findElement(buttonBuy) != null;
    }

    public String getTitleSet(){
        return driver.findElement(textTitleSet).getText();
    }

    public String getSubtitleSet(){
        return driver.findElement(textSubtitleSet).getText();
    }
}
