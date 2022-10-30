package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C01_handleWindowsYTDownloader {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() throws InterruptedException {
        //driver.get("https://www.amazon.com");
        //System.out.println(driver.getWindowHandle());
        //CDwindow-8C7A87E1AC62B32F1875137960F2D4F2
        //Bu kod window un unique hash kodudur.
        //Selenium sayfalari arasi gecislerde bu window handle degeri kullanilir
        //Eger sayfalar arasinda driver imizi gezdiriyorsak ve herhangi
        //bir sayfadan bulundugumuz sayfaya gecmek istiyorsak
        //driver.switchTo().window("CDwindow-8C7A87E1AC62B32F1875137960F2D4F2");
        //seklinde sayfanin hash degerini girerek o sayfaya gecis yapabiliriz


        //VIDEO OTOMATIK INDIRME KODU DENEMESI

        driver.get("https://www.youtube.com/c/AhmetBulutluoz/videos");


        //(//img[@id='img'])[12]

        int baslangic=12;
        String xpath1="(//img[@id='img'])"+"["+baslangic+"]";

        System.out.println(xpath1);
        WebElement video=driver.findElement(By.xpath(xpath1));






        //WebElement video=driver.findElement(By.xpath("//*[@id=\"video-title\"]"));

        video.click();
        String ytHash= driver.getWindowHandle();
        String videoUrl="";
        videoUrl=driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://en.savefrom.net/1-youtube-video-downloader-354/");

        Thread.sleep(5000);
        //WebElement iframe=driver.findElement(By.name("passive_signin"));
        //driver.switchTo().frame(iframe);

        WebElement indirmeKutu=driver.findElement(By.xpath("//input[@type='text']"));
        indirmeKutu.sendKeys(videoUrl);
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        WebElement dusukCozunurluk=driver.findElement(By.xpath("//*[@id=\"sf_result\"]/div/div/div[2]/div[2]/div[1]/a"));
        //Thread.sleep(5000);
        String downloadHash=driver.getWindowHandle().toString();
        dusukCozunurluk.click();

      Thread.sleep(5000);

      Set<String> handles=driver.getWindowHandles();

      String reklamHash="";

        for (String each:handles
             ) {
            if (!each.equals(downloadHash)){
                if (!each.equals(downloadHash)){
                    reklamHash=each;
                }
            }


        }

        driver.switchTo().window(reklamHash);
        driver.close();

        driver.switchTo().window(ytHash);

        Thread.sleep(5000);

        driver.navigate().back();

        Thread.sleep(5000);



        Thread.sleep(5000);

      video.click();










    }
}
