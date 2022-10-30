package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {
    @Test
    public void test1(){

        /*
        Onceki classdaki adrese gidip giris yap methodunu kullanarak sayfaya giris
        yapin ve input olarak verilen satir/sutun sayisina sahip olan
        cell deki text i yazdirin
         */

        driver.get("https://www.hotelmycamp.com/");

        driver.findElement(By.xpath("//a[@href='/Account/Logon']")).click();
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
        Actions actions=new Actions(driver);
        WebElement username=driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();

        int satir=3;
        int sutun=5;

        List<WebElement> sutunbasliklariListesi=driver.findElements(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        for (WebElement each:sutunbasliklariListesi
             ) {
            System.out.println(each.getText());

        }





    }
}
