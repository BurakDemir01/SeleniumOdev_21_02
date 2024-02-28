package Odev_03_Actions;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Soru1degisik extends BaseDriver {
    @Test
    public void Test1() {
        // Web sayfasını açma
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        MyFunc.Bekle(2);

        List<WebElement> sehirler = driver.findElements(By.xpath("//div[@class='dragDropSmallBox' and starts-with(@id,'a')]"));
        List<WebElement> ulkeler = driver.findElements(By.xpath("//div[@class='dragDropSmallBox' and starts-with(@id,'q')]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='dragDropSmallBox' and starts-with(@id,'a')]")));
        for (WebElement sehir : sehirler) {
            Actions actions = new Actions(driver);
            Action action = actions.clickAndHold(sehir).build();
            action.perform();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='dragDropSmallBox' and starts-with(@id,'q')]")));
            for (WebElement ulke : ulkeler) {
                if (sehir.getAttribute("id").substring(1).equals(ulke.getAttribute("id").substring(1))) {
                    action = actions.moveToElement(ulke).release().build();
                    action.perform();
                }
            }
        }
    }
}

