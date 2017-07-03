package pages.Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Ashwini on 30/05/2017.
 */
public class Supplier {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='Serv_1']")
    WebElement chkboxbus;
    @FindBy(xpath = "//*[@id='Serv_2']")
    WebElement chkboxairline;
    @FindBy(xpath = "//*[@id='Serv_3']")
    WebElement chkboxcar;
    @FindBy(xpath = "//*[@id='Serv_4']")
    WebElement chkboxhotel;
    @FindBy(xpath = "//*[@id='Serv_5']")
    WebElement chkboxtrain;
    @FindBy(xpath = "//*[@id='Serv_6']")
    WebElement chkboxvisa;
    @FindBy(xpath = "//*[@id='Serv_7']")
    WebElement chkboxpassport;
    @FindBy(xpath = "//*[@id='Serv_8']")
    WebElement chkboxmiscellaneous;
    @FindBy(xpath = "//*[@id='Serv_9']")
    WebElement chkboxinsurance;
    @FindBy(xpath = "//*[@id='Supp_Nm']")
    WebElement txtsupplier;
    @FindBy(xpath = "//*[@id='Supp_Addr']")
    WebElement txtaddress;
    @FindBy(xpath = "//*[@id='ddlState']")
    WebElement combostate;
    @FindBy(xpath = "//*[@id='ddlCity']")
    WebElement combocity;
    @FindBy(xpath = "//*[@id='Fax_No']")
    WebElement txtfaxno;
    @FindBy(xpath = "//*[@id='ST_Reg_No']")
    WebElement txtservicetaxno;
    @FindBy(xpath = "//*[@id='ContNo1']")
    WebElement txtcontactno1;
    @FindBy(xpath = "//*[@id='Cont_Persn']")
    WebElement txtcontcperson1;
    @FindBy(xpath = "//*[@id='ContNo2']")
    WebElement txtcontactno2;
    @FindBy(xpath = "//*[@id='Sec_Cont_Persn']")
    WebElement txtcontcperson2;
    @FindBy(xpath = "//*[@id='Supp_Email']")
    WebElement txtemailid;
    @FindBy(xpath = "//*[@id='Website']")
    WebElement txtwebsite;
    @FindBy(xpath = "//*[@id='ddl_BankNm']")
    WebElement combobankname;
    @FindBy(xpath = "//*[@id='Bank_Acc_No']")
    WebElement txtaccountno;
    @FindBy(xpath = "//*[@id='Branch_Nm']")
    WebElement txtbranchname;
    @FindBy(xpath = "//*[@id='Branch_Addr']")
    WebElement txtbranchadd;
    @FindBy(xpath = "//*[@id='MICR_No']")
    WebElement txtmicrno;
    @FindBy(xpath = "//*[@id='IFSC_Code']")
    WebElement txtifscno;
    @FindBy(xpath = "//*[@id='btnSubmit']")
    WebElement btnsave;
    @FindBy(xpath = "")
    WebElement btncancel;
    @FindBy(xpath = "//*[@id='confirm']")
    WebElement btnconfirm;

    public Supplier(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickbus()
    {
        chkboxbus.click();
    }
    public void clickairline()
    {
       chkboxairline.click();
    }
    public void clickcar()
    {
        chkboxcar.click();
    }
    public void clickhotel()
    {
        chkboxhotel.click();
    }
    public void clicktrain()
    {
        chkboxtrain.click();
    }
    public void clickvisa()
    {
        chkboxvisa.click();
    }
    public void clickpassport()
    {
        chkboxpassport.click();
    }
    public void clickmiscellaneous()
    {
        chkboxmiscellaneous.click();
    }
    public void clickinsurance()
    {
        chkboxinsurance.click();
    }
    public void setTxtsupplier(String sname)
    {
        txtsupplier.sendKeys(sname);
    }
    public void setTxtaddress(String sadd)
    {
        txtaddress.sendKeys(sadd);
    }
    public void setstate(String state)
    {
        Select select =new Select(combostate);
        select.selectByVisibleText(state);
    }
    public void setcity(String city)
    {
        Select select=new Select(combocity);
        select.selectByVisibleText(city);
    }
    public void setfaxno(String faxno)
    {
        txtfaxno.sendKeys(faxno);
    }
    public void setservicetaxno(String servicetaxno)
    {
        txtservicetaxno.sendKeys(servicetaxno);
    }
    public void setcontno1(String no1)
    {
        txtcontactno1.sendKeys(no1);
    }
    public void setcontperson1(String personname1)
    {
        txtcontcperson1.sendKeys(personname1);
    }
    public void setcontactno2(String no2)
    {
        txtcontactno2.sendKeys(no2);
    }
    public void setcontperson2(String personname2)
    {
        txtcontcperson2.sendKeys(personname2);
    }
    public void setemailid(String email)
    {

    }



}
