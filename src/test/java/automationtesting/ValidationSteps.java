package automationtesting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ValidationSteps {
    static Properties Navigation;
    private WebDriver driver;
    private PageObjects.AutomationTests homePage;

    @BeforeMethod
    public void setUp() throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/home/sara/IdeaProjects/Pros/src/test/java/dataProvider/config.properties");
        Navigation = new Properties();
        Navigation.load(fs);

        String browser = Navigation.getProperty("browser");
        DesiredCapabilities capability = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.WIN10);
        } else if (browser.equalsIgnoreCase("firefox")) {
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WIN10);
        } else if (browser.equalsIgnoreCase("IE")) {
            capability.setBrowserName("internet explorer");
            capability.setPlatform(Platform.WIN10);
        }

        driver = new RemoteWebDriver(new URL(Navigation.getProperty("NodeURL")), capability);
    }



    @Given("I open the website")
    public void iOpenTheWebsite() {
        driver = new ChromeDriver();
        homePage = new PageObjects.AutomationTests(driver);
        homePage.openWebsite("https://practice.automationtesting.in/");
    }

    @Then("I check the book {string} availability")
    public void iCheckTheBookAvailability(String bookName) {
        assertTrue(homePage.getBookName(bookName).isDisplayed());
    }

    @Then("I should see the price {string}")
    public void iShouldSeeThePrice(String expectedPrice) {
        String actualPrice = homePage.getBookPrice();
        // Assert that the actual price matches the expected price
        assertEquals(expectedPrice, actualPrice);
    }

    @When("I add the book {string} to the basket")
    public void iAddTheBookToTheBasket(String bookName) {
        homePage.getAddToBasketButton().click();
    }

    @Then("I should see the book in the basket")
    public void iShouldSeeTheBookInTheBasket() {
        assertTrue(homePage.checkItem().isDisplayed());
    }

    @When("I click on the shopping cart")
    public void iClickOnTheShoppingCart() {
        homePage.clickShoppingCart();
    }

    @Then("I should see the item added to the cart with its details")
    public void iShouldSeeTheItemAddedToTheCartWithItsDetails() {
    }

    @When("I click on proceed to checkout")
    public void iClickOnProceedToCheckout() {
        homePage.proceedToCheckout();
    }

    @Then("billing details form should be displayed")
    public void billingDetailsFormShouldBeDisplayed() {
        assertTrue(homePage.isBillingDetailsFormDisplayed());
        driver.quit();
    }
}
