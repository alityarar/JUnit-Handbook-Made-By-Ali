package day15_writeExcel_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JavaScriptExecutor extends TestBase {
    @Test
    public void JSTest() throws InterruptedException {
        //Amazon a gidelim
        //Assagidaki sign in butonu gorununceye kadar js ile scrool yapalim
        //sign in butonuna js ile click yapalim


        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));

        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);



        Thread.sleep(3000);


        jse.executeScript("arguments[0].click();",signInButonu);



    }
}
