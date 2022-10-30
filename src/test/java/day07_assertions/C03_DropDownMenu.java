package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDownMenu {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public static void end() {
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement dropdown=driver.findElement(By.xpath("(//select[@id='searchDropdownBox'])"));
        Select select=new Select(dropdown);

        //Kac tane select oldugunu bulma

        List<WebElement> optionsList = select.getOptions();

        int optionSayisi=optionsList.size();
        System.out.println("Selection sayisi : "+optionSayisi);

        select.selectByVisibleText("Books");

        System.out.println(select.getFirstSelectedOption().getText());
        WebElement textBox=driver.findElement(By.id("twotabsearchtextbox"));
        textBox.sendKeys("java"+ Keys.ENTER);
        //Bir dropdown ile calisiyorken son secilen option a ulasmak istiyorsak
        //select.getFirstSelectedOption() methodunu kullanmaliyiz
        
        //bu method bize webelement dondurur, getText() ile text yapabilirz

        Thread.sleep(5000);



    }

}
