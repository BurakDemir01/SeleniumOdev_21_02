package Wait_Scroll_Alert;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class Soru6 extends BaseDriver {
    /*6-
    Senaryo
    1- https://www.youtube.com/ adresine gidiniz
    2- "Selenium" kelimesi ile video aratınız.
    3- Listelenen sonuçlarda 80 videoaya kadar listeyi uzatınız.
    4- Son videonun title ını yazdırınız.*/
    @Test
    public void Senaryo6() {
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com/");
        MyFunc.Bekle(1);

        // "Selenium" kelimesini ara
        WebElement searchBox = driver.findElement(By.cssSelector("div[id='search-input'] input"));

        searchBox.sendKeys("Selenium");
        searchBox.submit(); // click()

        // Sayfada 80 tane web element oluşana kadar kaydıralım
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement lastVideo;
        List<WebElement> videoTitles = new ArrayList<>();
        do {
            //MyFunc.Bekle(1);
            lastVideo = driver.findElement(By.xpath("(//ytd-video-renderer)[last()]"));
            videoTitles.add(lastVideo);
            js.executeScript("arguments[0].scrollIntoView();", lastVideo);
        } while (videoTitles.size() < 80);

        // 80 adet Web element oluştuktan sonra 80. videonun title işlemleri
        WebElement video80 = videoTitles.get(videoTitles.size() - 1); // 80. videoyu size-1 ile aldık

        //String video80Text = video80.getAttribute("title"); // Aldığımız videonun title nı aldık
        String text = video80.getText();

        System.out.println("80.Video Title : " + text);
        System.out.println("videoTitles.size() = " + videoTitles.size());

        BekleKapat();

    }
}
