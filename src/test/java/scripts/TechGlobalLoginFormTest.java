package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.ConfigReader;

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
    @Test(priority = 4, description = "Validate forgot password link and reset password page")
    public void validateForgotPasswordAndResetPasswordPage(){
        techGlobalLoginFormPage.forgotPassword.click();

        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordHeader.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.resetPasswordHeader.getText(), "Reset Password");

        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.resetPasswordLabel.getText(),
                "Enter your email address and we'll send you a link to reset your password.");

        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordInput.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isDisplayed());
    }
    @Test(priority = 5, description = "Validate Reset Password functionality")
    public void validateResetPasswordLink(){
        techGlobalLoginFormPage.forgotPassword.click();
        techGlobalLoginFormPage.resetPasswordInput.sendKeys(ConfigReader.getProperty("email"));
        techGlobalLoginFormPage.submitButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.confirmationMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.confirmationMessage.getText(),
                "A link to reset your password has been sent to your email address.");
    }
    @Test(priority = 6, description = "Validate login with invalid username")
    public void validateLoginWithInvalidUsername(){
        techGlobalLoginFormPage.usernameInput.sendKeys(ConfigReader.getProperty("invalidUsername"));
        techGlobalLoginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid Username entered!']")).isDisplayed());
    }
    @Test(priority = 7, description = "Validate login with invalid password")
    public void validateLoginWithInvalidPassword(){
        techGlobalLoginFormPage.usernameInput.sendKeys(ConfigReader.getProperty("username"));
        techGlobalLoginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("invalidPassword"));
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid Password entered!']")).isDisplayed());
    }
    @Test(priority = 8, description = "Validate login with invalid username and password")
    public void validateLoginWithInvalidUsernameAndInvalidPassword(){
        techGlobalLoginFormPage.usernameInput.sendKeys(ConfigReader.getProperty("invalidUsername"));
        techGlobalLoginFormPage.passwordInput.sendKeys(ConfigReader.getProperty("invalidPassword"));
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid Username entered!']")).isDisplayed());
    }







}
