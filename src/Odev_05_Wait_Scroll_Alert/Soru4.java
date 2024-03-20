package Odev_05_Wait_Scroll_Alert;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
https://demoqa.com/dynamic-properties adresine gidin
1) “Visible After 5 seconds” butonunun gorunur olmasini bekleyin
2) “Visible After 5 seconds” butonunun gorunur oldugunu test edin
 */

public class Soru4 extends BaseDriver {
    @Test
    public void Test4(){
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://demoqa.com/dynamic-properties");

        WebElement willEnable = driver.findElement(By.cssSelector("button[id='enableAfter']"));
        wait.until(ExpectedConditions.visibilityOf(willEnable));
        System.out.println(willEnable.isDisplayed());
        Assert.assertTrue("Will Enable Görünür Değil",willEnable.isDisplayed());

        WebElement visibleAfter = driver.findElement(By.cssSelector("button[id='visibleAfter']"));
        wait.until(ExpectedConditions.visibilityOf(visibleAfter));
        System.out.println(visibleAfter.isDisplayed());
        Assert.assertTrue("Will After Görünür Değil",visibleAfter.isDisplayed());

        BekleKapat();
    }
}
