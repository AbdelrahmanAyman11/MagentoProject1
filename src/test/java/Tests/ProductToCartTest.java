package Tests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import BaseTestClass.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import Pages.*;
import Pages.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductToCartTest extends BaseClass {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void addToCart() {
        HomePage home = new HomePage(driver);
        home.search("Sweatshirt");
        new SearchPage(driver).clickFirstProduct();
        ProductPage product = new ProductPage(driver);
        product.setSize();
        product.setColor();
        product.clickAddToCartBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        Assert.assertTrue(driver.getPageSource().contains("You added"));
    }
}