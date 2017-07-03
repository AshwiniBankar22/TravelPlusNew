package resource;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ashwini on 17/06/2017.
 */
public class DateFunction {
     static WebDriver driver;

    public static void dateFun(WebDriver driver, String setdate) throws ParseException {

        //driver=openbrowser("chrome");
        //driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li[5]/a/span")).click();


        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        Date seDate=myDateFormat.parse(setdate);

        driver.findElement(By.xpath(".//*[@id='datetimepicker1']/span/span")).click();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='datetimepicker1']/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]")).getText());
        System.out.println(curDate);

        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(seDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        // decided whether set date is in past or future
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath(".//*[@id='datetimepicker1']/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
        // Click on Day of Month from table
        driver.findElement(By.xpath("//div[@class='datepicker']/div[1]//td[text()='" + (new DateTime(seDate).getDayOfMonth()) + "']")).click();


        //   return driver;
    }
}
