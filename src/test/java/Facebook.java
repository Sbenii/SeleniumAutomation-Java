import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
    WebDriver driver;

    @BeforeTest
    public void Prepare() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void End() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void InvalidSignIn() {
        String Iemail = System.getenv("Iemail");
        String Iphone = System.getenv("Iphone");
        String Ipass = System.getenv("Ipass");
        driver.findElement(By.id("email")).sendKeys(Iemail);
//        driver.findElement(By.id("email")).sendKeys(Iphone);
        driver.findElement(By.id("pass")).sendKeys(Ipass);
        driver.findElement(By.name("login")).click();
        String ActualResults = driver.findElement(By.xpath("//*[@id=\"error_box\"]/div[1]")).getText();
        System.out.println(ActualResults);
        String ExpectedResults = "Wrong Credentials";
        Assert.assertEquals(ActualResults, ExpectedResults);
    }


//    @Test(priority = 2)
//    public void InvalidFindAccount() {
//        driver.findElement(By.cssSelector("a[href*='facebook.com/login/identify']")).click();
//        String Iemail = System.getenv("Iemail");
//        driver.findElement(By.id("identify_email")).sendKeys(Iemail);
//        driver.findElement(By.name("did_submit")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement Msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identify_yourself_flow\"]/div/div[2]/div[1]/div[1]")));
//        String ActualResults = Msg.getText();
//        System.out.println(ActualResults);
//        String ExpectedResults = "No Search Results";
//        Assert.assertEquals(ActualResults, ExpectedResults);
//    }
//
//    @Test(priority = 3)
//    public void InvalidSignUp() {
//        //Cancel finding account
//        driver.findElement(By.xpath("//*[@id=\"identify_yourself_flow\"]/div/div[3]/div/div[1]/a")).click();
//        driver.findElement(By.className("_97w5")).click();
//        driver.findElement(By.name("firstname")).sendKeys("");
//        driver.findElement(By.name("lastname")).sendKeys("");
//        WebElement month = driver.findElement(By.id("month"));
//        Select selectMonth = new Select(month);
//        selectMonth.selectByValue("Aug");
//        WebElement day = driver.findElement(By.id("day"));
//        Select selectDay = new Select(day);
//        selectDay.selectByValue("26");
//        WebElement year = driver.findElement(By.id("year"));
//        Select selectYear = new Select(year);
//        selectYear.selectByValue("2005");
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[4]/span/span[2]/label/input"));
//        driver.findElement(By.name("reg_email__")).sendKeys("");
//        driver.findElement(By.id("password_step_input")).sendKeys("");
//        driver.findElement(By.name("websubmit"));
//    }
}
