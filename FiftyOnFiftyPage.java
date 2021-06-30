package ru.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiftyOnFiftyPage {
    private WebDriver driver;

    By linkCloseModalWindow = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/a");
    By linkSet = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div/span");
    By linkPizzaOne = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div/span");
    By linkPizzaTwo = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[3]/div/span");
    By linkBuy = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/a");
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
        driver.findElement(linkSet).click();
        return this;
    }

    public FiftyOnFiftyPage addPizzaOne(){
        driver.findElement(linkPizzaOne).click();
        return this;
    }

    public FiftyOnFiftyPage addPizzaTwo(){
        driver.findElement(linkPizzaTwo).click();
        return this;
    }

    public FiftyOnFiftyPage buySet(){
        driver.findElement(linkBuy).click();
        return this;
    }

    public boolean buttonBuyIsActive(){
        return driver.findElement(linkBuy) != null;
    }

    public String getTitleSet(){
        return driver.findElement(textTitleSet).getText();
    }

    public String getSubtitleSet(){
        return driver.findElement(textSubtitleSet).getText();
    }
}
