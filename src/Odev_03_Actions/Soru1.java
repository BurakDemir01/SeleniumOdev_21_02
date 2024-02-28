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

        for (int i = 0; i < sehirler.size(); i++) {
            Action aksiyon = aksiyondriver.clickAndHold(sehirler.get(i)).build();
            MyFunc.Bekle(5);
            for (WebElement ulke : ulkeler) {
                // MyFunc.Bekle(5);
                String color = ulke.getCssValue("background-color");
                if (color.contains("green")) {
                    // MyFunc.Bekle(5);
                    aksiyondriver.moveToElement(ulke).release().build().perform();
                }
            }
        }
    }
}
