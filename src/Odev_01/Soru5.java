package Odev_01;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru5 extends BaseDriver {
    @Test
    public void Test5(){
        /*
        Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        Fake Alerts' tıklayınız.
        Show Alert Box'a tıklayınız.
        Ok'a tıklayınız.
        Alert kapanmalıdır.
        */

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fake= driver.findElement(By.cssSelector("[id='fakealerttest']"));
        fake.click();
        MyFunc.Bekle(2);

        WebElement showFake= driver.findElement(By.cssSelector("[id='fakealert']"));
        showFake.click();
        MyFunc.Bekle(2);

        WebElement boxOk= driver.findElement(By.cssSelector("[id='dialog-ok']"));
        boxOk.click();
        MyFunc.Bekle(2);

        BekleKapat();
    }
}
