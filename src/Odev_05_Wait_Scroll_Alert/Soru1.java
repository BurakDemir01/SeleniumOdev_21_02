package Odev_05_Wait_Scroll_Alert;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

/*
1- google.com ile sayfayı açınız.
2- Daha sonra Yeni bir TAB (ctrl+T) açınız.
3- Bu açılan yeni sayfada facebook.com u açınız.
4- Bu sayfanın açıldığını URL sinden kontrol ediniz.
4- Daha sonra facebook.com sayfasını kapatınız.
 */
public class Soru1 extends BaseDriver {
    @Test
    public void Test1() {
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.urlToBe("https://www.google.com/"));

        //driver.switchTo().newWindow(WindowType.TAB);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);

        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        MyFunc.Bekle(1);

        Set<String> idler = driver.getWindowHandles();

        Iterator<String> gosterge = idler.iterator();
        String birinciSekmeID = gosterge.next().toString();
        String ikinciSekmeID = gosterge.next().toString();
        MyFunc.Bekle(1);

        driver.switchTo().window(ikinciSekmeID);

        driver.get("https://www.facebook.com/");
        wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/"));
        String url = driver.getCurrentUrl();
        System.out.println("Facebook URL'si : " + url);

        Assert.assertEquals("Facebook Sayfası Açılmadı", "https://www.facebook.com/", url);

        String[] array = idler.toArray(new String[idler.size()]); // Set'i diziyi çevirip içinde dolaşıp ID'leri almış olduk

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + 1 + " . Sekmenin ID'si : " + array[i]);

        }

        BekleKapat();

    }
}
