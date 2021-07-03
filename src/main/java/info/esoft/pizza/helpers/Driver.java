package info.esoft.pizza.helpers;

import com.codeborne.selenide.Selenide;
import info.esoft.pizza.constants.Const;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Driver implements Const {

    public WebDriver driver;

    /*private WebBrowsers Browser = WebBrowsers.GOOGLE;

    public enum WebBrowsers{
        GOOGLE,
        SAFARI,
        FIREFOX
    }*/

    @Before
    public void Up() throws InterruptedException {
        open(SyteInfo.LINK_SYTE);
        /*switch (Browser){
            case GOOGLE:
                createGoogleDriver();
                break;
            case SAFARI:
                createSafariDriver();
                break;
            case FIREFOX:
                createFireFoxDriver();
                break;
        }*/
    }

    @After
    public void Close() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public WebDriver createGoogleDriver(){
        System.setProperty(AllWebDrivers.NAME_GOOGLE_DRIVER, AllWebDrivers.PATH_GOOGLE_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver createSafariDriver(){
        System.setProperty(AllWebDrivers.NAME_SAFARI_DRIVER, AllWebDrivers.PATH_SAFARI_DRIVER);
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver createFireFoxDriver(){
        System.setProperty(AllWebDrivers.NAME_FIRE_FOX_DRIVER, AllWebDrivers.PATH_FIRE_FOX_DRIVER);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        closeWebDriver();
    }
}
