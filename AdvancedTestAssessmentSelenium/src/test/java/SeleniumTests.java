import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import sun.rmi.runtime.Log;

public class SeleniumTests {

    public WebDriver driver = null;
    ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\loginReport.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void OwnersCreate() {
        test = extent.startTest("Creation of user");
        driver.get("http://10.0.10.10:4200/petclinic/");
        test.log(LogStatus.INFO, "Site opened");
        CreateOwner co = PageFactory.initElements(driver, CreateOwner.class);

        driver.findElements(By.className("dropdown")).get(0).click();
        test.log(LogStatus.INFO, "Owners menu clicked");

        driver.findElements(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")).get(0).click();
        test.log(LogStatus.INFO, "All Owners button clicked and owners page Reached");

        driver.findElements(By.xpath("/html/body/app-root/app-owner-list/div/div/div/div/button")).get(0).click();
        test.log(LogStatus.INFO, "Add Owner button clicked and taken to create owner page");

        co.getName().sendKeys("Craig");
        co.getLastName().sendKeys("Gouldstone");
        co.getAddress().sendKeys("12ft avenue");
        co.getCity().sendKeys("Troon");
        co.getTelephone().sendKeys("0123456789");
        driver.findElements(By.xpath("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")).get(0).click();
        test.log(LogStatus.INFO, "Owner details entered and submitted");
    }

    @Test
    public void OwnerCreationShortcut(){
        driver.get("http://10.0.10.10:4200/petclinic/");

        CreateOwner co = PageFactory.initElements(driver, CreateOwner.class);
        driver.findElements(By.className("dropdown")).get(0).click();

        driver.findElements(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a")).get(0).click();

        co.getName().sendKeys("Almasa");
        co.getLastName().sendKeys("Pasalic");
        co.getAddress().sendKeys("557 brown avenue");
        co.getCity().sendKeys("Manchester");
        co.getTelephone().sendKeys("0123444789");
        driver.findElements(By.xpath("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")).get(0).click();
    }

    @After
    public void teardown(){
        driver.quit();
        extent.flush();
    }
}
