package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TechGlobalBasePage {
    public TechGlobalBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
