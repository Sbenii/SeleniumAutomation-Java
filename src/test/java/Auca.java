import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
        driver.findElement(By.id("Home")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public void AcademicBulletin() throws InterruptedException {
        WebElement element = driver.findElement(By.id("bulletinAudit"));
        element.sendKeys(Keys.HOME);
        Thread.sleep(1000);
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void CoursePrerequisites() throws InterruptedException {
        WebElement Course = driver.findElement(By.id("lbPrerequisite"));
        Course.sendKeys(Keys.HOME);
        Thread.sleep(1000);
        Course.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);

    }

    @Test(priority = 6)
    public void Balance() throws InterruptedException {
        WebElement Balance = driver.findElement(By.id("paymentHistory"));
        Balance.sendKeys(Keys.HOME);
        Thread.sleep(1000);
        Balance.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void FailedCourses() throws InterruptedException {
        WebElement Fail = driver.findElement(By.id("lbFailedCourses"));
        Fail.sendKeys(Keys.HOME);
        Thread.sleep(1000);
        Fail.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @Test(priority = 8)
    public void Chat() throws InterruptedException {
        WebElement Chat = driver.findElement(By.id("GotChat"));
        Chat.sendKeys(Keys.HOME);
        Thread.sleep(1000);
        Chat.click();
        driver.findElement(By.id("MessagesRepeater_lblChatTitle_0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("MessagesRepeater_lblChatTitle_1")).click();
        Thread.sleep(1000);
        WebElement List = driver.findElement(By.id("ListHeads"));
        List.click();
        Select select = new Select(List);
        select.selectByVisibleText("REGISTRAR - Hirwa Fabrice");
        Thread.sleep(1000);
        List.click();
    }

}

