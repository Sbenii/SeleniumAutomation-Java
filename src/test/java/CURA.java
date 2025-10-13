import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CURA {
    WebDriver driver;

    @BeforeTest
    public void Prepare() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        // Disable the password manager, credential services, and infobars
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.password_manager_enabled", false);
//        prefs.put("credentials_enable_service", false);
//        prefs.put("autofill.profile_enabled", false);
//        prefs.put("autofill.credit_card_enabled", false);
//        prefs.put("autofill.enabled", false);
//        options.setExperimentalOption("prefs", prefs);

        // Disable Chrome UI features that interfere with automation
//        options.addArguments("--disable-save-password-bubble");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-autofill-passwords");
//        options.addArguments("--disable-autofill-keyboard-accessory-view");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--no-default-browser-check");
//        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void End() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() throws InterruptedException {
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement facebookLink = driver.findElement(By.xpath("//i[@class='fa fa-facebook fa-fw fa-3x']"));
        js.executeScript("arguments[0].scrollIntoView(true)", facebookLink);
        Thread.sleep(500);
        facebookLink.click();
        WebElement twitterLink = driver.findElement(By.xpath("//i[@class='fa fa-twitter fa-fw fa-3x']"));
        js.executeScript("arguments[0].scrollIntoView(true)", twitterLink);
        Thread.sleep(500);
        twitterLink.click();
    }

    @Test(priority = 1)
    public void HamburgerMenu() throws InterruptedException {
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1500);
        //Return to home
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

    }

    @Test(priority = 2)
    public void InvalidSignIn() {
        WebElement username = driver.findElement(By.id("txt-username"));
        WebElement password = driver.findElement(By.id("txt-password"));
        username.sendKeys(" ");
        password.sendKeys(" ");
        driver.findElement(By.id("btn-login")).click();
        String ActualResults = driver.findElement(By.xpath("//p[@class='lead text-danger']")).getText();
        String ExpectedResults = "Login failed! Please ensure the username and password are valid.";
        Assert.assertEquals(ActualResults, ExpectedResults);
    }

    @Test(priority = 3)
    public void ValidSignIn() {
        String username = driver.findElement(By.xpath("//input[@value='John Doe']")).getAttribute("value");
        String password = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']")).getAttribute("value");
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
    }

    @Test(priority = 4)
    public void MakeAppointment() throws InterruptedException {

        WebElement Facility = driver.findElement(By.id("combo_facility"));
        Facility.click();
        Select select = new Select(Facility);
        select.selectByValue("Hongkong CURA Healthcare Center");
        Thread.sleep(1000);
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.xpath("//*[@id=\"radio_program_medicaid\"]")).click();

        Thread.sleep(3000);
    }

}
