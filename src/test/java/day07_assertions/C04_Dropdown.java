package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    static WebDriver driver;
    Select select=new Select(driver.findElement(By.xpath("(//select[@id='dropdown'])")));


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select=new Select(driver.findElement(By.xpath("(//select[@id='dropdown'])")));
    }

    @Test
    public void test1(){
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
    }
    @Test
    public void test2() {
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> selecttekiler=select.getOptions();
        int Liste=selecttekiler.size();
        System.out.println(Liste);
    }

    @AfterClass
    public static void end(){
        driver.close();
    }


}
