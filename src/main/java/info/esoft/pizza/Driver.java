package info.esoft.pizza;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public WebDriver driver;

    private WebBrowsers Browser = WebBrowsers.GOOGLE;

    public enum WebBrowsers{
        GOOGLE,
        SAFARI,
        FIREFOX
    }

    @Before
    public void Up(){
        switch (Browser){
            case GOOGLE:
                driver = createGoogleDriver();
                break;
            case SAFARI:
                driver = createSafariDriver();
                break;
            case FIREFOX:
                driver = createFireFoxDriver();
                break;
        }
    }

    @After
    public void Close() {
        closeDriver();
    }

    public WebDriver createGoogleDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver createSafariDriver(){
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver createFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/firefoxdriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}
