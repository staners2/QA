package info.esoft.pizza.helpers;

import com.codeborne.selenide.Configuration;
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

    private WebBrowsers Browser = WebBrowsers.GOOGLE;

    public enum WebBrowsers{
        GOOGLE,
        SAFARI,
        FIREFOX
    }

    @Before
    public void Up() throws InterruptedException {
        Configuration.timeout = 2000;
        switch (Browser){
            case GOOGLE:
                createGoogleDriver();
                break;
            case SAFARI:
                createSafariDriver();
                break;
            case FIREFOX:
                createFireFoxDriver();
                break;
        }
        open(SyteInfo.LINK_SYTE);
    }

    @After
    public void Close() {
        Selenide.closeWebDriver();
    }

    public void createGoogleDriver(){
        System.setProperty(AllWebDrivers.NAME_GOOGLE_DRIVER, AllWebDrivers.PATH_GOOGLE_DRIVER);
        Configuration.browser = "google";
    }

    public void createSafariDriver(){
        System.setProperty(AllWebDrivers.NAME_SAFARI_DRIVER, AllWebDrivers.PATH_SAFARI_DRIVER);
        Configuration.browser = "safari";
    }

    public void createFireFoxDriver(){
        System.setProperty(AllWebDrivers.NAME_FIRE_FOX_DRIVER, AllWebDrivers.PATH_FIRE_FOX_DRIVER);
        Configuration.browser = "firefox";
    }

    public void closeDriver() {
        closeWebDriver();
    }
}
