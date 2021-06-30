package ru.pizza;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AuthorizationPage {
    public WebDriver driver;

    By linkMyAccount = By.xpath("//*[@id=\'appContainer\']/div/div[1]/div[1]/div/span[2]/a");
    By inputNumber = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/input");
    By linkSendNumber = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[2]/a");
    By inputCode = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[2]/input");
    By linkSendCode = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[2]/a");
    By conditionOne = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[3]/div[1]/a/i");
    By conditionTwo = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div[3]/div[2]/a/i");

    private String token = "o.Z77alssDKwkTsgyTpRr6q6EoOJIgSECm";
    private String number = "9516085864";

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(linkMyAccount).click();
    }

    public MainPage authorization(){
        sendNumber();
        acceptConditionOne();
        acceptConditionTwo();
        submitNumber();
        String code = getCodeAuthorization();
        sendCode(code);
        return null;
    }

    private String getCodeAuthorization(){
        /*JSONObject object = new JSONObject();
        object.put();*/

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Access-Token", token);
        // request.body(object.toString());
        Response response = request.get("https://api.pushbullet.com");
        /*try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }*/
        System.out.println(response.getBody());
        return response.toString();
    }

    private void sendNumber(){
        driver.findElement(inputNumber).sendKeys(number);
    }

    private void sendCode(String code){
        driver.findElement(inputCode).sendKeys(code);
        driver.findElement(linkSendCode).click();
    }

    private void acceptConditionOne(){
        driver.findElement(conditionOne).click();
    }

    private void acceptConditionTwo(){
        driver.findElement(conditionTwo).click();
    }

    private void submitNumber(){
        driver.findElement(linkSendNumber).click();
    }
}
