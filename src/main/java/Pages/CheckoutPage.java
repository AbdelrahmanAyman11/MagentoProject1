package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void fillEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email"))).sendKeys(email);    }

    public void fillFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input"))).sendKeys(firstName);    }

    public void fillLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input"))).sendKeys(lastName);    }

    public void fillCompany(String Company) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[3]/div/input"))).sendKeys(Company);    }
    public void fillStreet(String street) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input"))).sendKeys(street);    }

    public void fillCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input"))).sendKeys(city);    }

//    public void fillState(String state) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("region"))).sendKeys(state);
//    }

    public void fillZip(String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input"))).sendKeys(zip);    }

    public void selectCountry(String countryName) {
        WebElement CountryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select")));
        Select CountrySelect = new Select(CountryDropdown);
        CountrySelect.selectByVisibleText(countryName);
    }

    public void fillPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input"))).sendKeys(phone);    }

    public void selectShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input"))).click();    }

    public void clickNext() {
        driver.findElement(By.cssSelector(".button.action.continue.primary")).click();
    }

    public void waitUntilLoaderDisappears() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout"))).click();
    }

    public boolean isOrderConfirmed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-success")));
        return driver.getPageSource().contains("Thank you for your purchase!");
    }
}
