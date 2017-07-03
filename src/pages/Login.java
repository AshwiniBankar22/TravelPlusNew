package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ashwini on 30/04/2017.
 */
public class Login {
  WebDriver driver;
    @FindBy(xpath = "//*[@id='Email_Id']")
    WebElement txtusername;
    @FindBy(xpath = "//*[@id='Password']")
    WebElement txtpassword;
    @FindBy(xpath = "//*[@id='btnSubmit1']")
    WebElement btnsignin;

    public Login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setTxtusername(String uname)
    {
        txtusername.sendKeys(uname);
    }
    public void setTxtpassword(String pass)
    {
        txtpassword.sendKeys(pass);
    }
    public void clicksignin()
    {
        btnsignin.click();
    }


}
