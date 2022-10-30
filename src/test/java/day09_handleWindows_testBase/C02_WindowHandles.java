package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandles {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/windows");


    }

    @Test
    public void test(){
        String expectedText="Opening a new window";
        WebElement actualText=driver.findElement(By.xpath("//h3"));
        String actualTextText=actualText.getText();
        Assert.assertTrue(expectedText.equals(actualTextText));

    }
    @Test
    public void test2() {
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    @Test
            public void test3(){
        WebElement clickButton=driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickButton.click();
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle().toString();
        System.out.println(actualTitle);
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }
    @Test
    public void test4(){
        String firstHandle=driver.getWindowHandle();
        WebElement clickButton=driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickButton.click();
        driver.switchTo().window(firstHandle);
        String oldexpectedTitle="New Window";
        String oldActualTitle=driver.getTitle().toString();
        Assert.assertEquals(oldActualTitle,oldexpectedTitle);


    }

}
