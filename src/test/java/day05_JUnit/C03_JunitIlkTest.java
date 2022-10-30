package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JunitIlkTest {


    WebDriver driver;
    @Before
    public void baslangic(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("baslangic calisti");
    }
    @After
    public void bitis(){
        driver.close();
        System.out.println("after calisti");
    }


    @Test
    public void method1(){
        driver.get("https://www.amazon.com");
        System.out.println("test1 calisti");

    }
    @Test
    public void method2(){
        driver.get("https://facebook.com");
        System.out.println("test2 calisti");
    }
}
