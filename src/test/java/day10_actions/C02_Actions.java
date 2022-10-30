package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //amazona gidip accounts menusunden create a list menusune tiklayalim


        Actions actions=new Actions(driver);


        driver.get("https://www.amazon.com");

        WebElement accountLink=driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        actions.moveToElement(accountLink).perform();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


        
    }


}
