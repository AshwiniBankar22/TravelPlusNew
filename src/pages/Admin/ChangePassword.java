package pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ashwini on 23/05/2017.
 */
public class ChangePassword {
WebDriver driver;
@FindBy(xpath = "//*[@id='oldPassword']")
    WebElement txtoldpass;
@FindBy(xpath = "//*[@id='Password']")
    WebElement txtnewpass;
@FindBy(xpath = "//*[@id='ConfirmPassword']")
    WebElement txtconfirmpass;
@FindBy(xpath = "//*[@id='btnSubmit']")
    WebElement btnchange;
@FindBy(xpath = "//div/div[3]/a")
    WebElement btncancel;
@FindBy(xpath = "html/body/div[1]/div/div[2]/div/div/div[3]/button[2]")
WebElement btnyes;

public ChangePassword(WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver,this);
}
public void setTxtoldpass(String opass)
{
    txtoldpass.sendKeys(opass);
}
public void setTxtnewpass(String npass)
{
    txtnewpass.sendKeys(npass);
}
public void setTxtconfirmpass(String confmpass)
{
    txtconfirmpass.sendKeys(confmpass);
}
public void clickbtnchange()
{
    btnchange.click();
}
public void clickYes() {
        //WebDriverWait wait=new WebDriverWait(driver,30);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[2]/div/div/div[3]/button[2]")));
        //btnyes.click();
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",btnyes);
       /*Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();*/
    }



}
