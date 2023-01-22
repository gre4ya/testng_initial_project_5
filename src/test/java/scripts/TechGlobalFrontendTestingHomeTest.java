package scripts;

import org.testng.annotations.BeforeMethod;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalFrontendTestingHomeTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
    }
}
