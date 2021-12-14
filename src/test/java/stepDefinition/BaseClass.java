package stepDefinition;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {
    final static String DRIVER_PATH = "C:/Users/720201/OneDrive - Finastra/Desktop/Learning/chromedriver.exe";
    public static WebDriver driver;
    public static DesiredCapabilities dc = new DesiredCapabilities();


    public WebDriver setDriver(String url)  {
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        driver = new ChromeDriver(dc);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }
}
