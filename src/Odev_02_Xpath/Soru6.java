package Odev_02_Xpath;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru6 extends BaseDriver {
    @Test
    public void Test6(){
        /*
        Bu siteye gidiniz. https://testpages.herokuapp.com/styled/index.html
        Fake Alerts'e tıklayınız.
        Show modal dialog buttonuna tıklayınız.
        Ok'a tıklayınız.
        Alert kapanmalıdır.
         */

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Bekle(2);
        WebElement fakeAlerts= driver.findElement(By.xpath("//div[@class='page-body']//a[@id='fakealerttest']"));
        fakeAlerts.click();

        MyFunc.Bekle(2);
        WebElement showModel= driver.findElement(By.xpath("(//div[@class='page-body']//input[@class='styled-click-button'])[2]"));
        showModel.click();

        MyFunc.Bekle(2);
        WebElement okButton= driver.findElement(By.xpath("//div[@class='dialog-actions']//button"));
        okButton.click();
        MyFunc.Bekle(2);

        BekleKapat();
    }
}
