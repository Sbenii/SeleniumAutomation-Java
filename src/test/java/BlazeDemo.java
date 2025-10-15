import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BlazeDemo {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void End() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.navigate().to("https://blazedemo.com/");
    }

    @Test(priority = 1)
    public void CheckDestinationOfTheWeek() throws InterruptedException {
        driver.findElement(By.partialLinkText("destination of the week! The Beach!")).click();
        String Place = driver.findElement(By.xpath("/html/body/div[2]")).getText();
        System.out.println(Place);
        driver.findElement(By.partialLinkText("Travel")).click();
    }

    @Test(priority = 2)
    public void FindFlight() {
        WebElement DepartureCity = driver.findElement(By.name("fromPort"));
        WebElement DestinationCity = driver.findElement(By.name("toPort"));
        Select selectDeparture = new Select(DepartureCity);
        Select selectDestination = new Select(DestinationCity);
        DepartureCity.click();
        selectDeparture.selectByValue("São Paolo");
        DepartureCity.click();
        DestinationCity.click();
        selectDestination.selectByValue("Cairo");
        DestinationCity.click();
        driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();

    }

    @Test(priority = 3)
    public void ChooseFlight() {
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")).click();
    }

    @Test(priority = 4)
    public void PersonalInformation() {
        driver.findElement(By.id("inputName")).sendKeys("John Doe");
        driver.findElement(By.id("address")).sendKeys("123Main ST");
        driver.findElement(By.id("city")).sendKeys("San Fransisco");
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        WebElement CardType = driver.findElement(By.id("cardType"));
        CardType.click();
        Select select = new Select(CardType);
        select.selectByVisibleText("American Express");
        CardType.click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("000001111122");
        driver.findElement(By.id("creditCardYear")).sendKeys("2030");
        driver.findElement(By.id("nameOnCard")).sendKeys("John Doe");
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
    }

    @Test(priority = 5)
    public void Confirmation() {
        String ActualResult = driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
        String ExpectedResult = "Thank you for your purchase today!";
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

    @Test(priority = 6)
    public void PurchaseInformation() {
        String Information = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody")).getText();
        System.out.println(Information);
    }

    @Test(priority = 7)
    public void InvalidSignUp() {
        driver.findElement(By.partialLinkText("home")).click();
        String email = System.getenv("Email");
        String pass = System.getenv("Pass");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.name("remember")).click();
        driver.findElement(By.partialLinkText("Login")).click();
    }
}
