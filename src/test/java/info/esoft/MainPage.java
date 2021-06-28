package info.esoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public WebDriver OpenSyte(WebDriver driver, String sWebSyte, boolean isAuthorize){
        // driver.manage().addCookie();
        driver.get(sWebSyte);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/a")).click();
        return driver;
    }


}
