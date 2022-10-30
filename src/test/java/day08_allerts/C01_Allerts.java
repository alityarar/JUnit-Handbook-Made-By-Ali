package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {


    /*
    Allertler kisaca bir siteye girdigimizde ilk cikan uyarilardir
    incele yapilabilenler otomasyonla tiklanabilir ama sag tik
    calismayanlar java script alertlerdir ve incele yapilamaz

    Onun yerine selenium un araclariyla tiklanabilir yada
   kapatilabilirler
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void after() {
        driver.close();
    }

    @Test
    public void Test() {
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement text=driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText="You successfully clicked an alert";

        Assert.assertTrue(expectedText.equals(text.getText()));


    }

    @Test
    public void test2() {
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String unwantedText="succed";
        WebElement text=driver.findElement(By.xpath("//p[@id='result']"));
        String realText=text.getText();
        Assert.assertFalse(realText.contains(unwantedText));


    }

    @Test
    public void test3() {
        driver.findElement(By.xpath("(//button[@onclick='jsPrompt()'])")).click();
        String myName="Ali";
        driver.switchTo().alert().sendKeys(myName);
        driver.switchTo().alert().accept();
        WebElement text=driver.findElement(By.xpath("//p[@id='result']"));
        String result=text.getText();
        Assert.assertTrue(result.contains(myName));


    }
}
