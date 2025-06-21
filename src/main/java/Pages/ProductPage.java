package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    By size = By.id("option-label-size-143-item-166");
    By color = By.xpath("//*[@id=\"option-label-color-93-item-59\"]");
//    By QTY = By.id("");
    By addToCartBtn = By.id("product-addtocart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void setSize() {
        WebElement sizeElement = wait.until(ExpectedConditions.elementToBeClickable(size));
        sizeElement.click();    }

    public void setColor() {
        WebElement colorElement = wait.until(ExpectedConditions.elementToBeClickable(color));
        colorElement.click();    }

    public void clickAddToCartBtn() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addBtn.click();
    }
}