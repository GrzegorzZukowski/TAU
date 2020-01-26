import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirstTest {
    public static void main(String[] args)

    {

        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("https://poczta.o2.pl/zaloguj");

        driver.findElement(By.id("input#login.form_input")).sendKeys("fakeaccount02");

        driver.findElement(By.id("input#password.form_input")).sendKeys("haslo1234");

        driver.findElement(By.id("button#login-button.btn.btn--1")).click();

        driver.quit();

    }
}

