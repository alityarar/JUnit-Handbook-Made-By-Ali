package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    -amazon ana sayfaya gidin
    -3 farkli test methodu olusturarak assagidaki gorevleri yapin

     1- url in amazon icerdigini test edin
     2-title in facebook icermedigin test edin
     3-sol ust kosede amazon logosunun gorundugunu test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {

        //-url in amazon icerdigini test edin
        String aranankelime="amazon";
        String actualKelime=driver.getCurrentUrl();
        Assert.assertTrue(actualKelime.contains(aranankelime));

    }

    @Test
    public void test2() {

        //-title in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void test3() {

        //sol ustte amazon logosu oldugunu test edin
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertFalse(logo.isDisplayed());


    }

}
