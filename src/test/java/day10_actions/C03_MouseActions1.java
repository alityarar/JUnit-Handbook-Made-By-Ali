package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {

 @Test

    public void test(){

     Actions actions = new Actions(driver);
     driver.get("https://the-internet.herokuapp.com/context_menu");

     //driver.findElement(By.xpath("//div[@id='hot-spot']")).

     WebElement kutu=driver.findElement(By.xpath("//div[@id='hot-spot']"));
     actions.contextClick(kutu).perform();

     String allert = driver.switchTo().alert().getText().toString();
     String expectedAllert="You selected a context menu";
     System.out.println(allert);
     String hash1=driver.getWindowHandle().toString();


     Assert.assertEquals(allert,expectedAllert);

     driver.switchTo().alert().accept();

     driver.findElement(By.xpath("//a[@target='_blank']")).click();

     String hash2=driver.getWindowHandle().toString();

     Set<String> hashler= driver.getWindowHandles();

     String has2has;

     for (String each:hashler
          ) {
         if (!each.equals(hash1)){
             hash2=each;
         }
     }




     driver.switchTo().window(hash2);

     String tag=driver.findElement(By.xpath("//h1")).getText().toString();

     String expectedTag ="Elemental Selenium";

     Assert.assertEquals(expectedTag,tag);


 }
}
