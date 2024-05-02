package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CucumberDeleteAccountTest {
    WebDriver driver;

    private static final By CUSTOMERS_BUTTON = By.xpath("//*[@id=\"menu-customer\"]/a");
    private static final By CUSTOMERS_DROPDOWN_BUTTON = By.xpath("//*[@id=\"collapse5\"]/li[1]/a");
    private static final By CUSTOMER_FOR_REMOVING_CHECKBOX = By.xpath("//*[@id=\"form-customer\"]/table/tbody/tr[3]/td[1]/input");
    private static final By DELETE_BUTTON = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button[2]/i");
    private static final By ASSERTION_MESSAGE = By.xpath("//*[@id=\"content\"]/div[2]/div[1]");

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("The user is on the web page")
    public void theUserIsOnTheWebPage() {
        driver.get("https://shop.pragmatic.bg/admin");
    }

    @When("He enters the credentials")
    public void heEntersTheCredentials() {
        driver.findElement(By.id("input-username")).sendKeys("admin");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @When("He deletes account")
    public void heDeletesAccount() {
        driver.findElement(CUSTOMERS_BUTTON).click();
        driver.findElement(CUSTOMERS_DROPDOWN_BUTTON).click();
        driver.findElement(CUSTOMER_FOR_REMOVING_CHECKBOX).click();
        driver.findElement(DELETE_BUTTON).click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (
                NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    @Then("Checks removing the account")
    public void checksRemovingTheAccount() {
        String messageAfterSuccessfullRemoving = driver.findElement(ASSERTION_MESSAGE).getText();
        Assert.assertEquals(messageAfterSuccessfullRemoving, "Success: You have modified customers!\n" +
                "×");

    }

}
