package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.ConfigReader;
import utilities.Waiter;

public class TechGlobalLoginFormTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        //getLoginFormTestingPage();

    }
    public void loginWithValidCredentials(){
        techGlobalLoginFormPage.usernameInput.sendKeys(ConfigReader.getProperty("username"));
        techGlobalLoginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        techGlobalLoginFormPage.loginButton.click();
    }

//    public void getLoginFormTestingPage(){
//        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
//        techGlobalFrontendTestingHomePage.clickOnCard(15);
//    }

    @Test(priority = 1, description = "Validate Login header")
    public void validateLoginFormCard(){
        Assert.assertTrue(techGlobalLoginFormPage.mainHeading.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.mainHeading.getText(), "Login Form");

        Assert.assertTrue(techGlobalLoginFormPage.usernameLabel.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.usernameInput.isEnabled());

        Assert.assertTrue(techGlobalLoginFormPage.passwordLabel.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.passwordInput.isEnabled());

        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());

        Assert.assertTrue(techGlobalLoginFormPage.forgotPassword.isDisplayed());
    }
    @Test(priority = 2, description = "Validate Login functionality with valid credentials")
    public void validateValidLogin(){
//        techGlobalLoginFormPage.usernameInput.sendKeys(ConfigReader.getProperty("username"));
//        techGlobalLoginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
//        techGlobalLoginFormPage.loginButton.click();
        loginWithValidCredentials();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You are logged in']")).isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
    }
    @Test(priority = 3, description = "Validate Login and Logout functionalities with valid credentials")
    public void validateValidLoginAndLogout(){
        loginWithValidCredentials();
        techGlobalLoginFormPage.logoutButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login Form']")).isDisplayed());
    }
    @Test
    public void validateForgotPasswordAndResetPasswordPages(){
        techGlobalLoginFormPage.forgotPassword.click();

    }






}
