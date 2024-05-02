package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CucumberAddNewCommentTest {

    WebDriver driver;
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

    private static final By VIEWMORE_ORDERS_BUTTON = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div[1]/div/div[3]/a");
    private static final By LAST_ORDER_VIEW_BUTTON = By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr[1]/td[8]/div/div/a");
    private static final By COMMENT_INPUT_FIELD = By.id("input-comment");
    private static final By ADD_HISTORY_BUTTON = By.id("button-history");
    private static final By ADDED_COMMENT = By.cssSelector("#history > div.table-responsive > table > tbody > tr:nth-child(1) > td:nth-child(2)");

    @Given("The user is on the correct web page")
    public void theUserIsOnTheCorrectWebPage() {
        driver.get("https://shop.pragmatic.bg/admin");
    }
    @When("He enters the credentials and login")
    public void heEntersTheCredentialsAndLogin() {
        driver.findElement(By.id("input-username")).sendKeys("admin");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
    @When("He adds new comment")
    public void heAddsNewComment() {
        driver.findElement(VIEWMORE_ORDERS_BUTTON).click();
        driver.findElement(LAST_ORDER_VIEW_BUTTON).click();
        driver.findElement(COMMENT_INPUT_FIELD).click();
        driver.findElement(COMMENT_INPUT_FIELD).sendKeys("New comment");
        driver.findElement(ADD_HISTORY_BUTTON).click();
    }
    @Then("He checks the result with assert")
    public void heChecksTheResultWithAssert() {
        String addedComment = driver.findElement(ADDED_COMMENT).getText();
        Assert.assertEquals(addedComment, "New comment");
    }

}
