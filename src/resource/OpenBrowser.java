package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Ashwini on 30/04/2017.
 */


   public class OpenBrowser {


        public static WebDriver driver;
        public static WebDriver openbrowser(String BroweserName) {
            switch (BroweserName) {
                case "firefox":

                    driver = new FirefoxDriver();

                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();


                    break;
                case "IE":
                    System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
                    driver = new InternetExplorerDriver();

                    break;
                default:
                    System.out.println("browser : " + BroweserName + " is invalid, Launching Firefox as browser of choice..");
                    driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
            return driver;
        }

        public static WebDriver getUrl(String url)
        {
            driver.get("http://travel.tfleet.in/");

            return null;
        }


    }


