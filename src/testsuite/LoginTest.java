package testsuite;
/*
Write down the following test in the ‘LoginTest’ class

1. userSholdLoginSuccessfullyWithValid

Credentials()
* Enter “standard_user” for the username
* Enter “secret_sauce” for the password
* Click on the ‘Login’ button
* Verify the text “Products”

2. verifyThatSixProductsAreDisplayedOnPage()
* Enter “standard_user” for the username
* Enter “secret_sauce” for the password
* Click on the ‘Login’ button
* Verify that six products are displayed
on page
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement productsText = driver.findElement(By.className("title"));
        Assert.assertEquals("Products", productsText.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        int numberOfProducts = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(6, numberOfProducts);

    }
}
