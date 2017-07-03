package resource;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.server.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ashwini on 26/06/2017.
 */
public class TakeScreenShots {
    public static String takescreenshots(WebDriver driver) throws IOException {
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //SimpleDateFormat sd=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String DateStr=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
        String imageName="screenshot"+ DateStr + ".png";
        String imagePath="Extent-Report/screenshots/"+imageName;
        FileUtils.copyFile(srcFile, new File(imagePath));

        return imageName;


    }
}
