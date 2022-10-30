package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    static WebDriver driver;

    @BeforeClass
            public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        String expectedUrl="https://www.amazon.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test2() {
        String istenmeyenIcerik="Rest";
        String title=driver.getTitle();
        Assert.assertFalse(title.contains(istenmeyenIcerik));
    }

    @Test
    public void test3() {

    }


    
}
