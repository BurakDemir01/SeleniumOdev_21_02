package Odev_02_Xpath;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Soru2 extends BaseDriver {
    @Test
    public void Test(){
        /*
        1) Bu siteye gidin. -> https://demo.applitools.com/
        2) Username kısmına "ttechno@gmail.com" girin.
        3) Password kısmına "techno123." girin.
        4) "Sign in" buttonunan tıklayınız.
        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.
        */

        driver.get(" https://demo.applitools.com/");

        MyFunc.Bekle(2);
        WebElement userName= driver.findElement(By.xpath("(//div[@class='form-group'])[1]//input"));
        userName.sendKeys("ttechno@gmail.com");

        MyFunc.Bekle(2);
        WebElement password= driver.findElement(By.xpath("(//div[@class='form-group'])[2]//input"));
        password.sendKeys("techno123");

        MyFunc.Bekle(2);
        WebElement button= driver.findElement(By.xpath("//div[@class='buttons-w']/a"));
        button.click();

        MyFunc.Bekle(2);
        WebElement text= driver.findElement(By.xpath("//div[@class='element-wrapper compact pt-4']/h6[@id='time']"));
        Assert.assertTrue("Mesaj bulunamadi", text.getText().contains("Your nearest branch closes in: 30m 5s"));

        BekleKapat();
    }
}
