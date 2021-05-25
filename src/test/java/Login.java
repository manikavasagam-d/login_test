import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Login {
    public String baseUrl = "https://staging.joinswoop.com/login";
    public WebDriver driver ;
    String driverPath = "/tmp/chromedriver";
    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching headless browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void verifyHomepageTitle() {
        System.out.println("Verify home page title");
        String expectedTitle = "Swoop";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}