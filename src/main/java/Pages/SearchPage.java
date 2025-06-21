package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    By SProduct = By.cssSelector(".product-item-link");

    public SearchPage(WebDriver driver) {

        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-item-link")));
        driver.findElement(SProduct).click();
    }
}
