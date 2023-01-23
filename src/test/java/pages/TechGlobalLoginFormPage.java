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
    @FindBy(id = "logout")
    public WebElement logoutButton;
    @FindBy(id = "forgot-password")
    public WebElement forgotPassword;
    @FindBy(xpath = "//*[text()='You are logged in']")
    public WebElement loginMessageText;
    @FindBy(xpath = "//*[text()='Login Form']")
    public WebElement loginFormText;
    @FindBy(xpath = "//*[text()='Invalid Username entered!']")
    public WebElement invalid_username_message;
    @FindBy(xpath = "//*[text()='Invalid Password entered!']")
    public WebElement invalid_password_message;


//    public void getLoginFormTestingPage(){
//        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
//        techGlobalFrontendTestingHomePage.clickOnCard(15);
//    }







}
