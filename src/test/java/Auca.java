import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auca {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void end() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.navigate().to("https://registration.auca.ac.rw/Login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void InvalidSignIn() {
        driver.findElement(By.id("txtUsername")).sendKeys("");
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("btnLogin")).click();

    }

    @Test(priority = 2)
    public void ValidSignIn() {
        String ID = System.getenv("ID");
        String pass = System.getenv("Pass");
        driver.findElement(By.id("txtUsername")).sendKeys(ID);
        driver.findElement(By.id("txtPassword")).sendKeys(pass);
        driver.findElement(By.id("btnLogin")).click();

    }

    @Test(priority = 3)
    public void Home() throws InterruptedException {
        driver.findElement(By.id("Home"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public void AcademicBulletin() throws InterruptedException {
        WebElement element = driver.findElement(By.id("bulletinAudit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        element.sendKeys(Keys.PAGE_UP);
        Thread.sleep(1000);
        element.click();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        WebElement UpKey = driver.findElement(By.id("Home"));
        UpKey.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        UpKey.click();
    }

    @Test(priority = 5)
    public void CoursePrerequisites() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.id("lbPrerequisite")).click();
        WebElement Down = driver.findElement(By.xpath("//footer[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", Down);

    }

    @Test(priority = 6)
    public void Balance() {
        driver.findElement(By.id("paymentHistory")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight");

    }
}

