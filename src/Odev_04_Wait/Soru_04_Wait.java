package Wait;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Soru_04_Wait extends BaseDriver {
    /*
    Senaryo
    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
    2- random 100 e kadar 2 sayı üretiniz.
    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
    4- Sonuçları Assert ile kontrol ediniz.
    5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
 */
    @Test
    public void Senaryo1() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        MyFunc.Bekle(1);
        Actions driverAksiyon = new Actions(driver);

        int rndSayi1 = (int) (Math.random() * 100);
        int rndSayi2 = (int) (Math.random() * 100);

        String strRndSayi1 = String.valueOf(rndSayi1);
        String strRndSayi2 = String.valueOf(rndSayi2);

        new Actions(driver).
                scrollByAmount(0, 900).
                build().
                perform();

        WebElement firstNo = driver.findElement(By.cssSelector("[id='number1Field']"));
        //MyFunc.Bekle(2);
        //Action firstNoAksiyon = driverAksiyon.scrollToElement(firstNo).build();
        wait.until(ExpectedConditions.visibilityOf(firstNo));
        //firstNoAksiyon.perform();

        Action elamanGonder1 = driverAksiyon.moveToElement(firstNo).click().sendKeys(strRndSayi1).build();
        elamanGonder1.perform();

        WebElement secondNo = driver.findElement(By.cssSelector("[id='number2Field']"));

//        Action secondNoAksiyon = driverAksiyon.scrollToElement(secondNo).build();
//        wait.until(ExpectedConditions.visibilityOf(secondNo));
//        secondNoAksiyon.perform();

        wait.until(ExpectedConditions.visibilityOf(secondNo));
        Action elamanGonder2 = driverAksiyon.moveToElement(secondNo).click().sendKeys(strRndSayi2).build();
        elamanGonder2.perform();

        WebElement operationLabel = driver.findElement(By.xpath("//select[@id='selectOperationDropdown']"));
        operationLabel.click();

        wait.until(ExpectedConditions.visibilityOf(operationLabel));
        Select operationMenu = new Select(operationLabel);
        operationMenu.selectByIndex(0); // index ile value 0 dan saymaya başlıyor
        //operationMenu.selectByValue("0");
        //operationMenu.selectByVisibleText("Add");

        WebElement calculateButton = driver.findElement(By.cssSelector("[id='calculateButton']"));

        Action forCalculate = driverAksiyon.moveToElement(calculateButton).click().build();
        wait.until(ExpectedConditions.visibilityOf(calculateButton));
        forCalculate.perform();

        MyFunc.Bekle(2);
        WebElement answer = driver.findElement(By.xpath("(//div[@class='row'])[9]//input"));
//        WebElement answer = driver.findElement(By.xpath("(//div[@class='col-sm-7'])[6]"));
        System.out.println("answer.getAttribute(type) = " + answer.getAttribute("type"));
        System.out.println("answer.getCssValue(overflow) = " + answer.getCssValue("overflow"));
        MyFunc.Bekle(2);
        wait.until(ExpectedConditions.visibilityOf(answer));
        MyFunc.Bekle(2);
        System.out.println("answer.getText() = " + answer.getText());


        //Assert.assertFalse("Sonuç Ekranda Çıkmadı", answer.getText().length() > 0);
        System.out.println("answer.isDisplayed() = " + answer.isDisplayed());
        System.out.println("answer.isEnabled() = " + answer.isEnabled());


        //Assert.assertFalse("Sonuç Yok", answer.getText().isEmpty()); // Bunu @CihatKose hocamıza soralım

        BekleKapat();
    }
}