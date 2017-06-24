package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Женя on 24.06.2017.
 */
public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getInstance(){
        if (driver != null){
            return driver;
        } else{
            return initWebDriver();
        }
    }

    private static WebDriver initWebDriver(){
        switch (getBrowser()){
            case CHROME: System.setProperty("webdriver.chrome.driver", Parameters.getWebdriverChromeDriver());
                driver = new ChromeDriver();
                break;
            case FIREFOX: System.setProperty("webdriver.gecko.driver", Parameters.getWebdriverFirefoxDriver());
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Parameters.getImplicityWait(), TimeUnit.SECONDS);
        return driver;
    }

    private static Browsers getBrowser(){
        String browser = Parameters.getBROWSER();
        switch (browser){
            case "Chrome": return Browsers.CHROME;
            case "Firefox": return Browsers.FIREFOX;
            default: throw new RuntimeException(String.format("Указанный браузер [%s] не поддерживается", browser));
        }
    }
}
