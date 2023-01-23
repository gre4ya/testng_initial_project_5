package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalForgotPasswordPage extends TechGlobalBasePage{
    public TechGlobalForgotPasswordPage(){super();}

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordHeader;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "confirmation_message")
    public WebElement passwordResetConfirmationMessage;
    @FindBy(tagName = "label")
    public WebElement resetPasswordLabel;
    @FindBy(tagName = "input")
    public WebElement resetPasswordInput;

}
