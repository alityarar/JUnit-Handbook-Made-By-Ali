package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test1(){
        /*
        Dosya yuklerken yada gonderirken normal sartlar altinda selenium kullanamayiz

        Ancak sendKeys() bize yardimci olur.

        1-dosya gonder tusunu locate edip basicaz
        2-dosya yolumuzu hazirliycaz
        3-
         */

       driver.get("https://the-internet.herokuapp.com/upload");
       WebElement buton=driver.findElement(By.xpath("//input[@id='file-upload']"));

       String farkliKisim=System.getProperty("user.home");
       String ortakKisim="\\Desktop\\text.txt";
       String yuklenecek=farkliKisim+ortakKisim;
        System.out.println(yuklenecek);

       //sendKeys ile dosya yolunu secme butonuna yollayalim

        buton.sendKeys(yuklenecek);

        driver.findElement(By.xpath("//input[@class='button']")).click();

        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());

    }
}
