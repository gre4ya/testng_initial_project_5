package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    static WebDriver driver;

    public static void login(WebElement usernameInput, WebElement passwordInput, String username, String password, WebElement loginButton){
        driver = Driver.getDriver();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
