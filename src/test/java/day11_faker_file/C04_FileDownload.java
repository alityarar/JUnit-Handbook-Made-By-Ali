package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/katalon.txt']")).click();
        String indirme= System.getProperty("user.home");
        String indirme2= "\\İndirilenler\\katalon.txt";
                //C:\Users\Ders\Downloads
        System.out.println(indirme+indirme2);

        String total=indirme+indirme2;

        Assert.assertFalse(Files.exists(Paths.get(total)));

        String dosyayolu=System.getProperty("user.home")+"\\Desktop\\text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }
}
