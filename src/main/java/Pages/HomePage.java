package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait ;

    By searchBox = By.id("search");

    public HomePage(WebDriver driver) {
        this.driver = driver;
       wait =new WebDriverWait(driver, Duration.ofSeconds(12));
    }
    public void search(String word) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div")));
        driver.findElement(searchBox).sendKeys(word + Keys.ENTER);
    }
}
