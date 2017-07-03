import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ashwini on 22/05/2017.
 */
public class DataProviderDemo {
    WebDriver driver;
    @BeforeClass
    public void openbrowser()
    {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://travel.tfleet.in/");
    }

    @Test(dataProvider = "userinput")
    public void login(String uname, String pass)
    {
        driver.findElement(By.xpath("//*[@id='Email_Id']")).sendKeys(uname);
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id='btnSubmit1']")).click();
    }

    @DataProvider
    public Object[][] userinput()throws IOException
    {
        FileInputStream file =new FileInputStream("exceldata/travelplus.xls");
        HSSFWorkbook wbook =new HSSFWorkbook(file);
        HSSFSheet wsheet=wbook.getSheet("Login");
         int rowcount=wsheet.getPhysicalNumberOfRows();
        System.out.println(rowcount);

        String [][] data =new String[rowcount-1][2];
        for (int i=1;i<rowcount;i++)
        {
            HSSFRow row=wsheet.getRow(i);
            HSSFCell ucell=row.getCell(0);
            if (ucell==null)
            {
                data[i-1][0]="";
            }else
            {
                data[i-1][0]=ucell.getStringCellValue();
            }

            HSSFCell pcell =row.getCell(1);
            if (ucell==null)
            {
                data[i-1][1]="";
            }else
            {
                data[i-1][1]=ucell.getStringCellValue();
            }
        }
        return data;
    }
}
