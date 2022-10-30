package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Deneme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");

        WebElement signin=driver.findElement(By.id("signin_button"));
        signin.click();

        WebElement login=driver.findElement(By.id("user_login"));
        login.sendKeys("username");

        WebElement pass = driver.findElement(By.id("user_password"));
        pass.sendKeys("password");

        WebElement giris=driver.findElement(By.name("submit"));
        giris.click();




    }
}
