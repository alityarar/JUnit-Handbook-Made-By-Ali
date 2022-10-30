package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    @Test
    public void test(){
        driver.get("https://demoqa.com/droppable");
        WebElement tut = driver.findElement(By.id("draggable"));
        WebElement birak=driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);

        actions.dragAndDrop(tut,birak).perform();

    }

}
