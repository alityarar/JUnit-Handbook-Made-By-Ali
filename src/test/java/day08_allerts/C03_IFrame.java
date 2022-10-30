package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IFrame {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void Test() {
       WebElement yazi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isEnabled());
    }
    @Test
    public void test2() throws InterruptedException {

        //Iframe kullanimi

        WebElement iFrame=driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iFrame);

        WebElement text=driver.findElement(By.xpath("//body[@id='tinymce']"));

        //Bazen bekletmemiz gerekebilir
        Thread.sleep(5000);

        //Kutuda onceden yazilan seyi silip temizleme
        text.clear();

        text.sendKeys("Hi World");

        //onceki frame switch kodu bu \ en ust icin default- bir onceki icin parent frame

        driver.switchTo().defaultContent();


    }
    @Test
    public void test3() {
        WebElement link=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(link.isEnabled());
    }
}
