package pages.Admin;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ashwini on 30/04/2017.
 */
public class UserMaster {
    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement headpagetitle;

    @FindBy(xpath = "//div/div[1]/a")
    WebElement btnaddnew;

    @FindBy(xpath = "//*[@id='Emp_Nm']")
    WebElement txtempname;
    @FindBy(xpath = "//*[@id='Email']")
    WebElement txtemailid;
    @FindBy(xpath = "//*[@id='Password']")
    WebElement txtpassword;
    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    WebElement txtRetypepass;
    @FindBy(xpath = "//*[@id='Designation']")
    WebElement selectdesignation;
    @FindBy(xpath = "//*[@id='ContNo1']")
    WebElement txtmobileno;
    @FindBy(xpath = "//*[@id='Address']")
    WebElement txtaddress;
    @FindBy(xpath = "//*[@id='Add_info']")
    WebElement txtaddinformation;
    @FindBy(xpath = "//*[@id='btnSubmit']")
    WebElement btnsave;
    @FindBy(xpath = "//div[3]/a")
    WebElement btncancel;
    @FindBy(xpath = "html/body/div[1]/div/div[2]/div/div/div[3]/button[2]")
    WebElement btnyes;

    public UserMaster(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!headpagetitle.isDisplayed())
        {
            throw new IllegalStateException("This is not add user page");
        }


    }

    public void clickaddnew()
    {
        btnaddnew.click();
    }
    public void setempname(String ename)
    {
        txtempname.sendKeys(ename);
    }
    public void setTxtemailid(String email)
    {
        txtemailid.sendKeys(email);
    }
    public void setTxtpassword(String pass)
    {
        txtpassword.sendKeys(pass);
    }
    public void setTxtRetypepass(String repass)
    {
        txtRetypepass.sendKeys(repass);
    }
    public void setdesignation(String desig) {
        Select combo =new Select(selectdesignation);
        combo.selectByVisibleText(desig);

    }
    public void setTxtmobileno(String number)
    {
        txtmobileno.sendKeys(number);

    }
    public void setTxtaddress(String address)
    {
        txtaddress.sendKeys(address);
    }
    public void setTxtaddinformation(String info)
    {
        txtaddinformation.sendKeys(info);
    }
    public void clickbtnsave()
    {
        btnsave.click();
    }
    public void clickYes() {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[2]/div/div/div[3]/button[2]")));
        //btnyes.click();
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",btnyes);
       /*Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();*/
    }
}
