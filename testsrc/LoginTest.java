
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static resource.OpenBrowser.getUrl;
import static resource.OpenBrowser.openbrowser;
import static resource.TakeScreenShots.takescreenshots;

/**
 * Created by Ashwini on 30/04/2017.
 */
public class LoginTest {
    WebDriver driver;
    @BeforeClass
    public void l()
    {
        driver=openbrowser("chrome");
        getUrl("url");

    }

    @Test(dataProvider = "getLoginData")
        public void userinput(String uname,String pass) throws IOException {
        ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);
        ExtentTest test = extent.startTest("login Test", "login Test for enter Input");

        Login login=new Login(driver);

        login.setTxtusername(uname);
        test.log(LogStatus.INFO, "Username enter as" + uname);
        login.setTxtpassword(pass);
        test.log(LogStatus.INFO, "Password enter as" + pass);
        login.clicksignin();
        //System.out.println("Login sucessfull");

        test.log(LogStatus.INFO,"snapshots below"+test.addScreenCapture("./Screenshots"+ takescreenshots(driver)));
        extent.endTest(test);
        extent.flush();

    }

    @DataProvider
    public Object [][] getLoginData() throws IOException {
        FileInputStream file =new FileInputStream("exceldata/travelplus.xls");
        HSSFWorkbook wbk=new HSSFWorkbook(file);
        HSSFSheet sheet=wbk.getSheet("Login");

        int noofrows=sheet.getPhysicalNumberOfRows();

        String data[][]=new String[noofrows-1][2];

        for (int i=1;i<noofrows;i++)
        {
            HSSFRow row=sheet.getRow(i);

            HSSFCell usrnmcell=row.getCell(0);
            if (usrnmcell== null)
            {
                data[i-1][0]="";
            }else
            {
                usrnmcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][0]=usrnmcell.getStringCellValue();
            }

            HSSFCell passcell=row.getCell(1);
            if (passcell== null)
            {
                data[i-1][1]="";
            }else
            {
                passcell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][1]=passcell.getStringCellValue();
            }

        }

        return data;
    }



}
