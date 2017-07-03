import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Login;
import resource.OpenBrowser;

import static resource.OpenBrowser.getUrl;
import static resource.OpenBrowser.openbrowser;

/**
 * Created by Ashwini on 24/05/2017.
 */
public class OpenBrowserTest {
    public WebDriver driver;
    @BeforeSuite
    public void launchbrowser()
    {
        driver=openbrowser("chrome");
        getUrl("url");
        Login login=new Login(driver);
        login.setTxtusername("ashwini@tcrafttechnologies.com");
        login.setTxtpassword("tcraft123");
        login.clicksignin();
    }




}
