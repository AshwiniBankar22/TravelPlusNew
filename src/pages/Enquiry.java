package pages;

import datecode.DateFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Ashwini on 16/06/2017.
 */
public class Enquiry {
    static WebDriver driver;

    DateFunction dateFunction;

    @FindBy(xpath = "//ul/li[5]/a")
    WebElement lnkenquiry;

    @FindBy(xpath = "//a[text()='Add New']")
    WebElement btnadd;

    @FindBy(xpath = "//*[@id='ddl_CustNm']")
    WebElement combocustomername;

    @FindBy(xpath = "//*[@id='Subject']")
    WebElement txtsubject;

    @FindBy(xpath = "//*[@id='Enq_Dtls']")
    WebElement txtenquirydetails;

    @FindBy(xpath = "//*[@id='Source']")
    WebElement txtsource;

    @FindBy(xpath = "//*[@id='Destination']")
    WebElement txtdestination;

    @FindBy(xpath = "//*[@id='chkBus']")
    WebElement chkboxbus;


    public Enquiry(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickenquiry() {
        lnkenquiry.click();
    }

    public void clickaddnew() {
        btnadd.click();
    }

    public void setcustomername() {
        Select select = new Select(combocustomername);
        select.selectByIndex(1);
    }

    public void setsubject(String subject) {
        txtsubject.sendKeys(subject);
    }

    public void setenquirydetails(String details) {
        txtenquirydetails.sendKeys(details);
    }

    public void setsource(String source) {
        txtsource.sendKeys(source);
    }

    public void setdestination(String destination) {
        txtdestination.sendKeys(destination);
    }
}




