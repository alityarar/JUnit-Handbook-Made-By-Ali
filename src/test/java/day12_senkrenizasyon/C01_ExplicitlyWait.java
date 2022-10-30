package day12_senkrenizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //remove butonuna basalım

        WebElement remove=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        remove.click();
        WebElement itsGoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());


    }

    @Test
    public void explictyTesti(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //remove butonuna basalım

        WebElement remove=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        remove.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));


        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        /*
        WebElement itsGoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));

        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());


        Yazinin gorunur olmasini beklerken yazinin locate ini kullanmak sorun olusturur.
        Cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir.
        (HTML kodlari yazan developer farkli uygulamalar yapabilir)
        Bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz.


         */

    }


}
