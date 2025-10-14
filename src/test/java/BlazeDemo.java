import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
}
