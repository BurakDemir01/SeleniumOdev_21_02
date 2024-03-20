package Odev_05_Wait_Scroll_Alert;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
1) https://demoqa.com/dynamic-properties adresine gidin
2) “Will enable 5 seconds” butonunun enable olmasini bekleyin
3) “Will enable 5 seconds” butonunun enable oldugunu test edin
 */
public class Soru3 extends BaseDriver {
    @Test
    public void Test3(){
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://demoqa.com/dynamic-properties");

        WebElement willEnable = driver.findElement(By.xpath("//button[text()='Will enable 5 seconds']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Will enable 5 seconds']")));
        System.out.println(willEnable.isDisplayed());

        Assert.assertTrue("Will Enable Görünür Değil", willEnable.isDisplayed());

        BekleKapat();

    }
}
