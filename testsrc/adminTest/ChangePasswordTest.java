package adminTest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Admin.ChangePassword;
import pages.Login;
import pages.Menu;
import resource.OpenBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static resource.OpenBrowser.getUrl;
import static resource.OpenBrowser.openbrowser;

/**
 * Created by Ashwini on 23/05/2017.
 */
public class ChangePasswordTest {
    WebDriver driver;
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

    @Test(dataProvider = "getData")
    public void changePass(String oldpass,String newpass,String cnfmpass)
    {
        Menu menu=new Menu(driver);
        menu.clickChagepwd();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ChangePassword chpass=new ChangePassword(driver);

        chpass.setTxtoldpass(oldpass);
        chpass.setTxtnewpass(newpass);
        chpass.setTxtconfirmpass(cnfmpass);
        chpass.clickbtnchange();
        chpass.clickYes();
    }

    @DataProvider
    public Object[][] getData()throws IOException
    {
        FileInputStream file=new FileInputStream("exceldata/travelplus.xls");
        HSSFWorkbook wbk=new HSSFWorkbook(file);
        HSSFSheet sheet=wbk.getSheet("Change password");
        int rowcount=sheet.getPhysicalNumberOfRows();

        String [][]data=new String[rowcount-1][3];

        for (int i=1;i<rowcount;i++)
        {
            HSSFRow row=sheet.getRow(i);

            HSSFCell oldcell=row.getCell(0);
            if(oldcell==null)
            {
                data[i-1][0]="";
            }else
            {
                oldcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][0]=oldcell.getStringCellValue();
            }

            HSSFCell newcell=row.getCell(1);
            if(newcell==null)
            {
                data[i-1][1]="";
            }else
            {
                newcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][1]=newcell.getStringCellValue();
            }

            HSSFCell cnfmcell=row.getCell(2);
            if(cnfmcell==null)
            {
                data[i-1][2]="";
            }else
            {
                cnfmcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][2]=cnfmcell.getStringCellValue();
            }

        }
        return data;
    }
}
