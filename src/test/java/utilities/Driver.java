package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    private static WebDriver getDriver(){
        if(driver == null){
            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    break;
                default:
                    throw new IllegalStateException(browser + " browser does not match any case!!!");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
        }
        return driver;
    }


}
