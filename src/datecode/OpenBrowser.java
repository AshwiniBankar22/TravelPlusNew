package datecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Akshay85 on 4/5/2017.
 */
public class OpenBrowser {

    static WebDriver driver;
    public static WebDriver openbrowser(String BroweserName) {
        switch (BroweserName) {
            case "firefox":

                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();


                break;
            case "IE":
                System.setProperty("webdriver.chrome.driver", "driver/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();

                break;
            default:
                System.out.println("browser : " + BroweserName + " is invalid, Launching Firefox as browser of choice..");
                driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        return driver;
    }

    public static void getUrl(String url)
    {
        driver.get("http://travel.tfleet.in/");

    }


    }


