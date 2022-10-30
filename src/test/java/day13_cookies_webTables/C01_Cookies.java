package day13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test1(){
        driver.get("https://amazon.com");
        //Tum cookieleri listeleyin
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        System.out.println(cookiesSet);

        int sayac=1;
        /*for (Cookie each:cookiesSet
             ) {
            System.out.println(sayac+".nci cookie:"+each);
            System.out.println(sayac+".nci cookie value:"+each.getValue());
            sayac++;
        }

         */

        Cookie cookie=new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);
        sayac=1;
        cookiesSet=driver.manage().getCookies();
        for (Cookie each:cookiesSet
        ) {
            System.out.println(sayac+".nci cookie:"+each);
            System.out.println(sayac+".nci cookie value:"+each.getValue());
            sayac++;
        }
        Assert.assertTrue(cookiesSet.contains(cookie));


    }
}
