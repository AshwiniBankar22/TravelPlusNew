import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Enquiry;
import pages.Login;
import resource.DateFunction;

import java.text.ParseException;

import static resource.DateFunction.dateFun;
import static resource.OpenBrowser.getUrl;
import static resource.OpenBrowser.openbrowser;


/**
 * Created by Ashwini on 17/06/2017.
 */
public class EnquiryTest {
    WebDriver driver;

    DateFunction dateFunction;
    @BeforeClass
    public void launchbrowser()
    {
        driver=openbrowser("chrome");
        getUrl("url");

        Login login=new Login(driver);
        login.setTxtusername("ashwini@tcrafttechnologies.com");
        login.setTxtpassword("tcraft123");
        login.clicksignin();
    }

    @Test
    public void enquiryinput() throws ParseException {
        Enquiry enquiry=new Enquiry(driver);
        enquiry.clickenquiry();
        enquiry.clickaddnew();
        enquiry.setcustomername();
        enquiry.setsubject("enquiry for pune trip");
        enquiry.setenquirydetails("pune darshan trip ");
        enquiry.setsource("uruli");
        enquiry.setdestination("pune");
        dateFun(driver, "12/04/2016");

    }
}
