package Tests;

import BaseTestClass.BaseClass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;

import java.time.Duration;

public class CompletePurchaseTest extends BaseClass {

    @Test

    @Severity(SeverityLevel.CRITICAL)
    public void completeValidPurchase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Search and Add Product to Cart
        HomePage home = new HomePage(driver);
        home.search("hoodie");

        SearchPage results = new SearchPage(driver);
        results.clickFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.setSize();
        product.setColor();
        product.clickAddToCartBtn();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        // Proceed to Cart and Checkout
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        cart.openCart();
        cart.ProceedToCheckout();

        // Fill Shipping Information
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillEmail("noogafy567@gmail.com");
        checkout.fillFirstName("Abdelrahman");
        checkout.fillLastName("Ayman");
        checkout.fillCompany("Ain Shams");
        checkout.fillStreet("Fayrouz");
        checkout.fillCity("cairo");
        checkout.fillZip("11111");
        checkout.selectCountry("Egypt");
        checkout.fillPhone("01090405854");

//
//            // Select Shipping Method and Continue
            checkout.selectShippingMethod();
            checkout.clickNext();
//
//            // Place Order
            checkout.waitUntilLoaderDisappears();
            checkout.placeOrder();
//
//            // Assert Success
            Assert.assertTrue(checkout.isOrderConfirmed(), "Order confirmation message not found!");
//        } else {
//            System.out.println("⚠ Invalid phone number: " + phone);
//            Assert.fail("Phone number must be Numbers & exactly 11 digits!");
//        }


    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void completeInvalidPurchase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Search and Add Product to Cart
        HomePage home = new HomePage(driver);
        home.search("hoodie");

        SearchPage results = new SearchPage(driver);
        results.clickFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.setSize();
        product.setColor();
        product.clickAddToCartBtn();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        // Proceed to Cart and Checkout
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        cart.openCart();
        cart.ProceedToCheckout();

        // Fill Shipping Information
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillEmail("noogafy567@gmail.com");
        checkout.fillFirstName("Abdelrahman");
        checkout.fillLastName("Ayman");
        checkout.fillCompany("Ain Shams");
        checkout.fillStreet("Fayrouz");
        checkout.fillCity("cairo");
        checkout.fillZip("11111");
        checkout.selectCountry("Egypt");
        checkout.fillPhone("@@");
        System.out.println("⚠ Invalid phone number");
        Assert.fail("Phone number must be Numbers & exactly 11 digits!");
//
//            // Select Shipping Method and Continue
        checkout.selectShippingMethod();
        checkout.clickNext();
//
//            // Place Order
        checkout.waitUntilLoaderDisappears();
        checkout.placeOrder();
////

//


    }

}