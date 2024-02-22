package Odev_01;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru2 extends BaseDriver {
    @Test
    public void Test2() {
        driver.get("https://demo.applitools.com%22/");

        WebElement username = driver.findElement(By.cssSelector("[id='username']"));
        username.sendKeys("ttechno@gmail.com");
        MyFunc.Bekle(3);

        WebElement password = driver.findElement(By.cssSelector("[id='password']"));
        password.sendKeys("techno123.");
        MyFunc.Bekle(3);

        WebElement button = driver.findElement(By.cssSelector("[id='log-in']"));
        button.click();
        MyFunc.Bekle(3);

        WebElement text = driver.findElement(By.cssSelector("[id='time']"));
        Assert.assertTrue("Mesaj bulunamadi", text.getText().contains("Your nearest branch closes in: 30m 5s"));

        BekleKapat();

    }
}
