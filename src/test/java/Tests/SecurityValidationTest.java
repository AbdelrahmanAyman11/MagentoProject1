package Tests;
import Pages.HomePage;
import io.qameta.allure.Severity;
import utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTestClass.BaseClass;

import io.qameta.allure.*;

public class SecurityValidationTest extends BaseClass {


    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testEmailFieldAgainstXSS() {
        try {
            InputValidator.validateNoScript("<script>alert('XSS')</script>");
            Assert.fail("XSS not detected!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "XSS attempt detected in input: <script>alert('XSS')</script>");
        }
    }

    @Test
    public void testEmailFieldValidInput() {
        try {
            InputValidator.validateNoScript("test@example.com");
        } catch (IllegalArgumentException e) {
            Assert.fail("Valid input falsely flagged as XSS!");
        }
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSQLInjectionInSearch() {
        HomePage home = new HomePage(driver);

        String maliciousInput = "' OR 1=1 --";
        home.search(maliciousInput);

        String pageSource = driver.getPageSource().toLowerCase();
        Assert.assertFalse(pageSource.contains("sql syntax"),
                "Potential SQL injection vulnerability detected.");
        Assert.assertFalse(pageSource.contains("mysql_fetch"),
                "SQL error message found on page.");
    }

    @Test()
    @Severity(SeverityLevel.CRITICAL)
    public void testSQLInjectionInSearch2() {
        HomePage home = new HomePage(driver);

        String maliciousInput = "DROP TABLE user;";
        home.search(maliciousInput);

        String pageSource = driver.getPageSource().toLowerCase();
        Assert.assertFalse(pageSource.contains("sql syntax"),
                "Potential SQL injection vulnerability detected.");
        Assert.assertFalse(pageSource.contains("mysql_fetch"),
                "SQL error message found on page.");
    }
}
