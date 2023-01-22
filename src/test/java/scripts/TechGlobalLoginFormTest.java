package scripts;

import org.testng.annotations.BeforeMethod;
import pages.TechGlobalLoginFormPage;

public class TechGlobalLoginFormTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }
}
