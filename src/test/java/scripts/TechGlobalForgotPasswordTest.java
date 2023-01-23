package scripts;

import expected_texts.ExpectedTexts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalForgotPasswordPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import test_data.LoginTestData;

public class TechGlobalForgotPasswordTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalForgotPasswordPage = new TechGlobalForgotPasswordPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.forgotPassword.click();
    }
    @Test(priority = 4, description = "Validate forgot password link and reset password page")
    public void validateForgotPasswordAndResetPasswordPage(){
        Assert.assertTrue(techGlobalForgotPasswordPage.resetPasswordHeader.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.resetPasswordHeader.getText(), "Reset Password");

        Assert.assertTrue(techGlobalForgotPasswordPage.resetPasswordLabel.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.resetPasswordLabel.getText(),
                ExpectedTexts.resetPasswordMessage);

        Assert.assertTrue(techGlobalForgotPasswordPage.resetPasswordInput.isDisplayed());
        Assert.assertTrue(techGlobalForgotPasswordPage.submitButton.isDisplayed());
    }
    @Test(priority = 5, description = "Validate Reset Password functionality")
    public void validateResetPasswordLink(){
        techGlobalForgotPasswordPage.resetPasswordInput.sendKeys(LoginTestData.getValidEmail());
        techGlobalForgotPasswordPage.submitButton.click();
        Assert.assertTrue(techGlobalForgotPasswordPage.passwordResetConfirmationMessage.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.passwordResetConfirmationMessage.getText(),
                ExpectedTexts.resetPasswordConfirmationMessage);
    }
}
