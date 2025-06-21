package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriver driver;
    WebDriverWait wait;

    By cartIcon = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    By checkoutBtn = By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/button");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    }

    public void openCart() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")));
    driver.findElement(cartIcon).click();
    }

    public void ProceedToCheckout() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/button")));
      driver.findElement(checkoutBtn).click();
    }
}
