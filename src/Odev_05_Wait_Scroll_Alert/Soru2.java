package Odev_05_Wait_Scroll_Alert;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
1) https://demoqa.com/browser-windows adresine gidin
2) Alerts’e tiklayin
3) On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
4) Allert’in gorunur olmasini bekleyin
5) Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
6) Ok diyerek alerti kapatin
 */
public class Soru2 extends BaseDriver {
    @Test
    public void Test2(){
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://demoqa.com/browser-windows");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement alerts = driver.findElement(By.xpath("//span[text()='Alerts']"));
        js.executeScript("arguments[0].click();", alerts);

        wait.until(ExpectedConditions.urlContains("alerts"));

        WebElement alertWillClick = driver.findElement(By.cssSelector("button[id='timerAlertButton']"));
        js.executeScript("arguments[0].click();", alertWillClick);

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert Yazısı : " + alert1.getText());
        //Assert.assertTrue("Alerts Görünmedi", alert1.getText().equals("This alert appeared after 5 seconds"));
        Assert.assertEquals("Alerts Görünmedi", "This alert appeared after 5 seconds", alert1.getText());
        alert1.accept();

        BekleKapat();
    }
}
