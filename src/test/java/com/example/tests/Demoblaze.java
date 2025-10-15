package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class Demoblaze {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.blazedemo.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDemoblaze() throws Exception {
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1440,812 | ]]
        driver.get("https://blazedemo.com/");
        // Label: Check destination of the week
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.linkText("destination of the week! The Beach!")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.linkText("home")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.linkText("BlazeDemo")).click();
        // Label: Find flight
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.name("fromPort")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("San Diego");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.name("toPort")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("tr:nth-of-type(3) .btn")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("inputName")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("inputName")).clear();
        driver.findElement(By.id("inputName")).sendKeys("John Doe");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("address")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("123Main St");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("city")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("San Fransisco");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("state")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("state")).clear();
        driver.findElement(By.id("state")).sendKeys("Carifornia");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("zipCode")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("zipCode")).clear();
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("cardType")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        new Select(driver.findElement(By.id("cardType"))).selectByVisibleText("American Express");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("creditCardNumber")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("creditCardNumber")).clear();
        driver.findElement(By.id("creditCardNumber")).sendKeys("123456789012");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("creditCardYear")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2020");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("nameOnCard")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("nameOnCard")).clear();
        driver.findElement(By.id("nameOnCard")).sendKeys("John Dow");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("label.checkbox")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.linkText("home")).click();
        // Label: Register
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.linkText("Register")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("name")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("company")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("123");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("email")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("password")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        // ERROR: Caught exception [unknown command [typeSecret]]
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("password-confirm")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        // ERROR: Caught exception [unknown command [typeSecret]]
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("password")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        // ERROR: Caught exception [unknown command [typeSecret]]
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("password-confirm")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        // ERROR: Caught exception [unknown command [typeSecret]]
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        // Label: Login
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.linkText("Login")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.id("password")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        // ERROR: Caught exception [unknown command [typeSecret]]
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.name("remember")).click();
        // ERROR: Caught exception [unknown command [waitFor]]
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
