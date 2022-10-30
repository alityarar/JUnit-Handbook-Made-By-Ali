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
import java.util.Set;

public class C03_WindowHandles {
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
        String ilkHandleDegeri=driver.getWindowHandle().toString();
        System.out.println(ilkHandleDegeri);
        WebElement clickButton=driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickButton.click();
        System.out.println(driver.getWindowHandles());

        /*
        Handle Degerini Bilmedigimiz Sayfalarin Hash Kodlarini Ogrenme

        Eger birden fazla sayfa varsa ve biz bunlardan en az birisinin
        hash kodunu bilmiyorsak, driver.getWindowHandles() kodunu kullaniriz

        Bu kod bize Set dondurur ve icerisinde bizim acik olan sayfalarimizin
        kodlari yazar

        Bu kodlari String hale getirmek icin For Each kullanabiliriz
         */

        Set<String> handleSeti=driver.getWindowHandles();

        String ikinciSayfaninHash="";

        for (String each :handleSeti
             ) {
            if (!each.equals(handleSeti)){
                 ikinciSayfaninHash=each;
            }

        }
        System.out.println(ikinciSayfaninHash);
        driver.quit();

    }
}
