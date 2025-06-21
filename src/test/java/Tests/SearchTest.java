package Tests;

import BaseTestClass.BaseClass;
import Pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseClass {
    @Test
    public void validProductSearch() {
        HomePage home = new HomePage(driver);
        home.search("Jacket");
        Assert.assertTrue(driver.getPageSource().contains("Jacket"));
    }

    @Test
    public void invalidProductSearch() {
        HomePage home = new HomePage(driver);
        home.search("ABC5");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div")).getText(),"Your search returned no results.");
    }
}