package Odev_03_Actions;

import Utlity.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Soru3 extends BaseDriver {
    //challenge sorusu
    //Ödev 3: http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
    //         buradaki bütün şehirleri bütün ülkelere doğru şekilde topluca dağıtınız.

    @Test
    public void Senaryo3() {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        List<WebElement> cities = driver.findElements(By.xpath("//div[@id='dhtmlgoodies_dragDropContainer']//li"));
        List<WebElement> countries = driver.findElements(By.xpath("//div[@id='dhtmlgoodies_mainContainer']//ul"));

        wait.until(ExpectedConditions.visibilityOfAllElements(cities));

        for (WebElement country : countries) {

            for (WebElement city : cities) {
                try {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                } catch (NoAlertPresentException e) {

                }

                String boxId = country.getAttribute("id");
                if (city.getAttribute("groupid").equals(boxId)) {
                    Actions driverAksiyon = new Actions(driver);

                    Action aksiyon = driverAksiyon.clickAndHold(city).build();
                    aksiyon.perform();

                    wait.until(ExpectedConditions.visibilityOfAllElements(countries));

                    aksiyon = driverAksiyon.moveToElement(country).release().build();

                    wait.until(ExpectedConditions.visibilityOfAllElements(countries));

                    aksiyon.perform();
                }
            }
        }
        BekleKapat();
    }
}
