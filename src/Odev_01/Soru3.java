package Odev_01;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru3 extends BaseDriver {
    @Test
    public void Test3(){
        /*
        1) Bu siteye gidin. -> https://www.snapdeal.com/
        2) "teddy bear" aratın ve Search butonuna tıklayın.
        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.
         */

        driver.get("https://www.snapdeal.com%22/");

        WebElement arama= driver.findElement(By.cssSelector("[id='inputValEnter']"));
        arama.sendKeys("teddy bear");
        MyFunc.Bekle(3);

        WebElement button= driver.findElement(By.cssSelector("[class='searchTextSpan']"));
        button.click();
        MyFunc.Bekle(3);

        WebElement text=driver.findElement(By.cssSelector("[id='searchMessageContainer'] span[style='color: #212121; font-weight: normal'][ class='nnn']"));

        Assert.assertTrue("Aranan sonuc bulunamadi",text.getText().contains("We've got 308 results for teddy bear"));

        BekleKapat();
    }
}
