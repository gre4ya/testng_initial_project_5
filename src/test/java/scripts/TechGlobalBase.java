package scripts;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.TechGlobalBasePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalBase {

    WebDriver driver;
    TechGlobalBasePage techGlobalBasePage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        techGlobalBasePage = new TechGlobalBasePage();
    }
}
