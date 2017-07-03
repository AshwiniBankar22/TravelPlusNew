package ddateexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;


import static datecode.DateFunction.DateFun;
import static ddateexample.DateExam.dateFunc;

/**
 * Created by Ashwini on 24/06/2017.
 */
public class EnquiryDate {
    WebDriver driver;
    @Test
    public void a() throws ParseException {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://travel.tfleet.in/");
        driver.findElement(By.id("Email_Id")).sendKeys("ashwini@tcrafttechnologies.com");
        driver.findElement(By.id("Password")).sendKeys("tcraft123");
        driver.findElement(By.id("btnSubmit1")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li[5]/a/span")).click();
        dateFunc(driver, "12/08/2010");

    }
}
