package adminTest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Admin.UserMaster;
import pages.Login;
import pages.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static resource.OpenBrowser.getUrl;
import static resource.OpenBrowser.openbrowser;

/**
 * Created by Ashwini on 01/05/2017.
 */
public class UserMasterTest {
    WebDriver driver;
   @BeforeClass
    public void loadbrowser()
    {
        driver=openbrowser("chrome");
        getUrl("url");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Login login = new Login(driver);
        login.setTxtusername("ashwini@tcrafttechnologies.com");
        login.setTxtpassword("tcraft123");
        login.clicksignin();

    }

    @Test(dataProvider = "getData")
    public void umaster(String empname,String email,String pass,String confirmpass,String design,String mobilno,String addr,String addinfo)throws Throwable
    {

        Menu menu = new Menu(driver);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        menu.clickusermaster();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        UserMaster userMaster=new UserMaster(driver);
        userMaster.clickaddnew();
        userMaster.setempname(empname);
        userMaster.setTxtemailid(email);
        userMaster.setTxtpassword(pass);
        userMaster.setTxtRetypepass(confirmpass);
        userMaster.setdesignation(design);
        userMaster.setTxtmobileno(mobilno);
        userMaster.setTxtaddress(addr);
        userMaster.setTxtaddinformation(addinfo);
        userMaster.clickbtnsave();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        userMaster.clickYes();

    }

    @DataProvider
    public Object[][] getData()throws IOException
    {
        FileInputStream file=new FileInputStream("exceldata/travelplus.xls");
        HSSFWorkbook wbk =new HSSFWorkbook(file);
        HSSFSheet Usersheet=wbk.getSheet("Usermaster");
        int rowcount=Usersheet.getPhysicalNumberOfRows();

        String [][] data=new String[rowcount-1][8];
        for (int i=1;i<rowcount;i++)
        {
            HSSFRow row =Usersheet.getRow(i);
            HSSFCell empnmcell=row.getCell(0);
            if (empnmcell==null)
            {
                data[i-1][0]="";
            }else
            {
                empnmcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][0]=empnmcell.getStringCellValue();
            }

            HSSFCell emailcell=row.getCell(1);
            if (emailcell==null)
            {
                data[i-1][1]="";
            }else
            {
                emailcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][1]=emailcell.getStringCellValue();
            }

            HSSFCell passcell=row.getCell(2);
            if (passcell==null)
            {
                data[i-1][2]="";
            }else
            {
                passcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][2]=passcell.getStringCellValue();
            }

            HSSFCell retyppasscell=row.getCell(3);
            if (retyppasscell==null)
            {
                data[i-1][3]="";
            }else
            {
                retyppasscell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=retyppasscell.getStringCellValue();
            }

            HSSFCell desigcell=row.getCell(4);
            if (desigcell==null)
            {
                data[i-1][4]="";
            }else
            {
                desigcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][4]=desigcell.getStringCellValue();
            }

            HSSFCell mobilenocell=row.getCell(5);
            if (mobilenocell==null)
            {
                data[i-1][5]="";
            }else
            {
                mobilenocell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][5]=mobilenocell.getStringCellValue();
            }

            HSSFCell addrcell=row.getCell(6);
            if (addrcell==null)
            {
                data[i-1][6]="";
            }else
            {
                addrcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][6]=addrcell.getStringCellValue();
            }

            HSSFCell addinfocell=row.getCell(7);
            if (addinfocell==null)
            {
                data[i-1][7]="";
            }else
            {
                addinfocell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][7]=addinfocell.getStringCellValue();
            }
        }

        return data;
    }


}
