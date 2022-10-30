package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void webTTable(){
        driver.get("https://www.hotelmycamp.com/");
        girisyap();

    }

    private void girisyap() {
        driver.findElement(By.xpath("//a[@href='/Account/Logon']")).click();
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
        Actions actions=new Actions(driver);
        WebElement username=driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();

        List<WebElement> sutunbasliklariListesi=driver.findElements(By.xpath("//thead//tr[1]//td"));

        System.out.println("sutun sayisi : "+sutunbasliklariListesi.size());

        //Table daki tum body'i ve basliklari (headers) konsolda yazdirin

        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());


        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi : "+satirlarListesi.size());

        for (WebElement each: satirlarListesi
             ) {
            System.out.println(each.getText());

        }

        //4.satirdaki (row) elementleri konsolda yazdirin.

        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));

        for (WebElement each:cellList
             ) {
            System.out.println(each.getText());

        }

        //Email basligindaki tum elementleri(sutun) konsolda yazdirin


        List<WebElement> anaBasliklar=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int sayici=1;
        String email="";
        int emailDEger=0;
        for (WebElement each:anaBasliklar
             ) {
            System.out.println(sayici+"nci baslik : "+each.getText());
                if (each.getText().contains("Email")){
                   emailDEger=sayici;
                }
            sayici++;

        }
        System.out.println(emailDEger);

        int satirSayisi=satirlarListesi.size();
        System.out.println(satirSayisi);

        int trSayac=1;
        List<WebElement> emailSatiri=driver.findElements(By.xpath("//tbody//td["+emailDEger+"]"));
        for (WebElement each:emailSatiri
             ) {
            System.out.println(each.getText()+" ");


        }













    }
}
