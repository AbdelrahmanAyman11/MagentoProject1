package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;

    By cartIcon = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    By checkoutBtn = By.id("top-cart-btn-checkout");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void ProceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
