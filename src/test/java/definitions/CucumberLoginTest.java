package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CucumberLoginTest {
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

    @Given("The user is at the correct web page")
    public void theUserIsOnTheCorrectWebPage() {
        driver.get("https://shop.pragmatic.bg/admin");
    }

    @When("He enters the admin username")
    public void heEntersTheAdminUsernameAndPassword() {
         driver.findElement(By.id("input-username")).sendKeys("admin");
    }
    @And("He enters the admin password")
    public void HeEntersTheAdminPassword (){
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
    }

    @And("He clicks on the login button")
    public void HeClicksOnTheLoginButton() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("He makes the assertion")
    public void heMakesTheAssertion() {
        WebElement element = driver.findElement(By.xpath("//*[@id='user-profile']/ .."));
        String text = element.getText();
        Assert.assertEquals(text, "Milen Strahinski");
    }
}

