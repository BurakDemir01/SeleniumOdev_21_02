package Odev_03_Actions;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Soru1 extends BaseDriver {
    @Test
    public void Test1() {
        // Ödev 1 : http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
        // buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile bütün şehirleri doğru ülkere dağıtınız.

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        List<WebElement> sehirler = driver.findElements(By.cssSelector("[id='answerDiv'] div"));
        List<WebElement> ulkeler = driver.findElements(By.cssSelector("div[id='questionDiv'] [class='destinationBox']"));

        Actions aksiyondriver = new Actions(driver);
        for (WebElement sehir:sehirler) {
            MyFunc.Bekle(1);
            aksiyondriver.clickAndHold(sehir).build().perform();
            for (WebElement ulke : ulkeler) {
                //  String color = ulke.getCssValue("background-color");
                if (ulke.getCssValue("background-color").contains("green")) {
                    // MyFunc.Bekle(5);
                    aksiyondriver.moveToElement(ulke).release().build().perform();
                    System.out.println("Basarili");
                }
                // MyFunc.Bekle(5);

                //for (WebElement sehir : sehirler) {
                //    for (WebElement ulke : ulkeler) {
                //        String ulkeRenk = ulke.getCssValue("background-color");
                //        if (ulkeRenk.contains("rgba(0, 128, 0, 1)")) { // Eğer ülke kutusu boşsa ve yeşil renkteyse
                //            aksiyondriver.clickAndHold(sehir).moveToElement(ulke).release().build().perform();
                //            break; // Doğru ülkeyi bulduğumuzda döngüyü sonlandır
                //        }

            }
        }
    }
}
