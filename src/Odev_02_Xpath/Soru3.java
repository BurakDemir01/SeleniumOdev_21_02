package Odev_02_Xpath;

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

        driver.get("https://www.snapdeal.com/");

        MyFunc.Bekle(2);
        WebElement search= driver.findElement(By.xpath("//div[@class='col-xs-14 search-box-wrapper']/input"));
        search.sendKeys("teddy bear");

        MyFunc.Bekle(2);
        WebElement button= driver.findElement(By.xpath("//div[@class='col-xs-14 search-box-wrapper']//i"));
        button.click();

        MyFunc.Bekle(2);
        WebElement text= driver.findElement(By.xpath("//div[@id='searchMessageContainer']//span"));

        Assert.assertTrue("Aranan sonuc bulunamadi",text.getText().contains("We've got 308 results for teddy bear"));

        System.out.println("text.getText() = " + text.getText());
        BekleKapat();
    }
}
