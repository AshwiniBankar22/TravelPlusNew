package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ashwini on 02/05/2017.
 */
public class Menu {
    WebDriver driver;
    //Admin
    @FindBy(xpath = "html/body/div[1]/aside/section/ul/li[2]/a")
    WebElement lnkadmin;
    @FindBy(xpath = "//ul/li[2]/ul[1]/li/a")
    WebElement lnkusermaster;
    @FindBy(xpath = "//ul[2]/li/a")
    WebElement lnkchangepassword;
    @FindBy(xpath = "html/body/div[1]/aside/section/ul/li[2]/ul[3]/li/a")
    WebElement lnkpermission;




    public Menu(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickusermaster()
    {


        lnkadmin.click();
        /*JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", lnkadmin);*/
        lnkusermaster.click();
    }
    public void clickChagepwd()
    {
        lnkadmin.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", lnkchangepassword);
        //lnkchangepassword.click();
    }
    public void clickpermission()
    {
        lnkadmin.click();
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",lnkpermission);
        //lnkpermission.click();
    }
}
