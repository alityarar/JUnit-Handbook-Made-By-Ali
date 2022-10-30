package day12_senkrenizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicityWait extends TestBase {
    @Test
    public void enbleTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled());
        WebElement enableButon=driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButon.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));

        WebElement itsEnabled=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));

        Assert.assertTrue(itsEnabled.isDisplayed());
        Assert.assertTrue(enableKutusu.isEnabled());



    }
}
