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
import pages.Admin.Permission;
import pages.Login;
import pages.Menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static resource.OpenBrowser.getUrl;
import static resource.OpenBrowser.openbrowser;

/**
 * Created by Ashwini on 27/05/2017.
 */
public class PermissionTest {
    public WebDriver driver;
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
    public void addPermission(String username)
    {
        Menu menu=new Menu(driver);
        menu.clickpermission();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Permission permission=new Permission(driver);
        permission.clickusername(username);
        permission.clickusermastercheckbox();
        permission.clicksave();
        permission.clickbtnyes();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream file=new FileInputStream("exceldata/travelplus.xls");
        HSSFWorkbook wbk=new HSSFWorkbook(file);
        HSSFSheet sheet=wbk.getSheet("Permission");

        int rowcount=sheet.getPhysicalNumberOfRows();

        String [][] data=new String[rowcount-1][1];

        for (int i=1;i<rowcount;i++)
        {
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);

            if (cell==null)
            {
                data[i-1][0]="";
            }else
            {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][0]=cell.getStringCellValue();
            }
        }
        return data;

    }


}
