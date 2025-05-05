package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AutomationTests {
    private WebDriver driver;

    public AutomationTests(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public WebElement getBookName(String bookName) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + bookName + "')]"));
    }

    public String getBookPrice() {
        WebElement priceElement = driver.findElement(By.cssSelector("#text-22-sub_row_1-0-2-1-0 > div > ul > li > a.woocommerce-LoopProduct-link > span.price > ins > span"));
        return priceElement.getText();

    }

    public WebElement getAddToBasketButton() {
        return driver.findElement(By.cssSelector(".post-163 > .button"));
    }

    public void clickShoppingCart() {
        WebElement shoppingCart = driver.findElement(By.cssSelector("#text-22-sub_row_1-0-2-1-0 > div > ul > li > a.added_to_cart.wc-forward"));
        shoppingCart.click();
    }

    public WebElement checkItem(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Thinking in HTML')]"));
    }

    public void proceedToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("#page-34 > div > div.woocommerce > div > div > div > a"));
        proceedToCheckoutButton.click();
    }

    public boolean isBillingDetailsFormDisplayed() {
        WebElement billingDetailsForm = driver.findElement(By.cssSelector("#order_review"));
        return billingDetailsForm.isDisplayed();
    }
}
