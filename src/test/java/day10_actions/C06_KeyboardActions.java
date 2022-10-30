package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        WebElement kaydol=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions=new Actions(driver);
        actions.click(kaydol).perform();
        WebElement isim=driver.findElement(By.name("firstname"));
        actions.click(isim)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Veli")
                .sendKeys(Keys.TAB)
                .sendKeys("bosmail@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("SifreBu1234.")
                .sendKeys(Keys.TAB)
                .sendKeys("SifreBu1234.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("29")
                .sendKeys(Keys.TAB)
                .sendKeys("Eki")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



    }
}
