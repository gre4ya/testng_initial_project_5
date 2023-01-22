package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalLoginFormPage extends TechGlobalBasePage{

    public TechGlobalLoginFormPage(){}

    @FindBy(id = "main_heading")
    public WebElement mainHeading;

    @FindBy(xpath = "(//label)[1]")
    public WebElement usernameLabel;

    @FindBy(xpath = "(//label)[2]")
    public WebElement passwordLabel;

    @FindBy(xpath = "(//input)[1]")
    public WebElement usernameInput;

    @FindBy(xpath = "(//input)[2]")
    public WebElement passwordInput;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPassword;

    public void getLoginFormTestingPage(){

    }






}
