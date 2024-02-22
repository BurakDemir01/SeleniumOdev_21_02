package Odev_01_css;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru1 extends BaseDriver {

    @Test public void Test1(){
        /*
        1) Bu siteye gidin. -> http://demoqa.com/text-box
        2) Full Name kısmına "Automation" girin.
        3) Email kısmına "Testing@gmail.com" girin.
        4) Current Address kısmına "Testing Current Address" girin.
        5) Permanent Address kısmına "Testing Permanent Address" girin.
        6) Submit butonuna tıklayınız.
        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
        */

        driver.get("http://demoqa.com/text-box");
        MyFunc.Bekle(3);
        WebElement fullName=driver.findElement(By.cssSelector("[id='userName'][type='text']"));
        fullName.sendKeys("Automation");
        MyFunc.Bekle(2);

        WebElement email=driver.findElement(By.cssSelector("input[id='userEmail']"));
        email.sendKeys("Testing@gmail.com");
        MyFunc.Bekle(2);

        WebElement currentEmail=driver.findElement(By.cssSelector("[id='currentAddress']"));
        currentEmail.sendKeys("Testing Current Address");
        MyFunc.Bekle(2);

        WebElement permanent=driver.findElement(By.cssSelector("[id='permanentAddress']"));
        permanent.sendKeys("Testing Permanent Address");
        MyFunc.Bekle(2);
        //[id='submit']

        WebElement submit=driver.findElement(By.cssSelector("[id='submit']"));
        submit.click();
        MyFunc.Bekle(2);

        WebElement name = driver.findElement(By.cssSelector("[id='name'][class='mb-1']"));
        WebElement emailBox = driver.findElement(By.cssSelector("[id='email'][class='mb-1']"));

        Assert.assertTrue("Aranılan Mesaj Bulunamadı", name.getText().contains("Automation"));
        Assert.assertTrue("Aranılan Mesaj Bulunamadı", emailBox.getText().contains("Testing"));

        BekleKapat();
    }
}
