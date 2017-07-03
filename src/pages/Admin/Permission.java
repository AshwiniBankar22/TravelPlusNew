package pages.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Ashwini on 26/05/2017.
 */
public class Permission {
    WebDriver driver;
    @FindBy(xpath= ".//*[@id='ddl_EmpNm']")
    WebElement combousername;
    @FindBy(xpath = "//tr[1]/td[2]/input[2]")
    WebElement chkboxusermaster;
    @FindBy(xpath = "//div[4]/button")
    WebElement btnsave;
    @FindBy(xpath = "//div[3]/button[2]")
    WebElement btnyes;

    public Permission(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickusername(String uname)
    {
        Select select=new Select(combousername);
        select.selectByVisibleText(uname);

    }
    public void clickusermastercheckbox()
    {
        chkboxusermaster.click();
    }
    public void clicksave()
    {
        btnsave.click();
    }
    public void clickbtnyes()
    {
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",btnyes);
    }

}
