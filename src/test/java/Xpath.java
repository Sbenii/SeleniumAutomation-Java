import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[27]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys("12345");
        Thread.sleep(2000);

        driver.quit();
    }
}
