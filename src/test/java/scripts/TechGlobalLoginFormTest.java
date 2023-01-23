package scripts;

import expected_texts.ExpectedTexts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import test_data.LoginTestData;
import utilities.Login;

public class TechGlobalLoginFormTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
    }
    public void loginWithValidCredentials(){
        Login.login(techGlobalLoginFormPage.usernameInput, techGlobalLoginFormPage.passwordInput,
                LoginTestData.getValidUsername(), LoginTestData.getValidPassword(), techGlobalLoginFormPage.loginButton);
    }

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
        loginWithValidCredentials();
        Assert.assertTrue(techGlobalLoginFormPage.loginMessageText.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.loginMessageText.getText(), ExpectedTexts.loginMessage);
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
    }
    @Test(priority = 3, description = "Validate Login and Logout functionalities with valid credentials")
    public void validateValidLoginAndLogout(){
        loginWithValidCredentials();
        Assert.assertTrue(techGlobalLoginFormPage.loginFormText.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.loginFormText.getText(), ExpectedTexts.loginForm);
    }

    @Test(priority = 6, description = "Validate login with invalid username")
    public void validateLoginWithInvalidUsername(){
        Login.login(techGlobalLoginFormPage.usernameInput, techGlobalLoginFormPage.passwordInput,
                LoginTestData.getInvalidUsername(), LoginTestData.getValidPassword(), techGlobalLoginFormPage.loginButton);

        Assert.assertTrue(techGlobalLoginFormPage.invalid_username_message.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.invalid_username_message.getText(),
                ExpectedTexts.loginFormInvalidUsernameErrorMessage);
    }
    @Test(priority = 7, description = "Validate login with invalid password")
    public void validateLoginWithInvalidPassword(){
        Login.login(techGlobalLoginFormPage.usernameInput, techGlobalLoginFormPage.passwordInput,
                LoginTestData.getValidUsername(), LoginTestData.getInvalidPassword(), techGlobalLoginFormPage.loginButton);

        Assert.assertTrue(techGlobalLoginFormPage.invalid_password_message.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.invalid_password_message.getText(),
                ExpectedTexts.loginFormInvalidPasswordErrorMessage);
    }
    @Test(priority = 8, description = "Validate login with invalid username and password")
    public void validateLoginWithInvalidUsernameAndInvalidPassword(){
        Login.login(techGlobalLoginFormPage.usernameInput, techGlobalLoginFormPage.passwordInput,
                LoginTestData.getInvalidUsername(), LoginTestData.getInvalidPassword(), techGlobalLoginFormPage.loginButton);

        Assert.assertTrue(techGlobalLoginFormPage.invalid_username_message.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.invalid_username_message.getText(),
                ExpectedTexts.loginFormInvalidUsernameErrorMessage);
    }
}
