package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class testsDefinitionsSteps {
    static WebDriver driver;


    private static final By USERNAME_INPUT_FIELD = By.id("input-username");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By USERNAME_LABEL = By.xpath("//*[@id='user-profile']/ ..");

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

    @Given("The user is on the correct web page")
    public void theUserIsOnTheCorrectWebPage() {
        driver.get("https://shop.pragmatic.bg/admin");
    }

    @When("He enters the admin username and password")
    public void heEntersTheAdminUsernameAndPassword() {
         driver.findElement(By.id("input-username")).sendKeys("admin");
         driver.findElement(By.id("input-password")).sendKeys("parola123!");
         driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("He makes the assertion")
    public void heMakesTheAssertion() {
        WebElement element = driver.findElement(By.xpath("//*[@id='user-profile']/ .."));
        String text = element.getText();
        Assert.assertEquals(text, "Milen Strahinski");
    }
}

