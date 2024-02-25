package Odev_02_Xpath;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru4 extends BaseDriver {
    @Test
    public void Test4(){
        /*
        Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        Calculate'e tıklayınız.
        İlk input'a herhangi bir sayı giriniz.
        İkinci input'a herhangi bir sayı giriniz.
        Calculate button'una tıklayınız.
        Sonucu alınız.
        Sonucu yazdırınız.
         */

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Bekle(2);
        WebElement calculater= driver.findElement(By.xpath("(//div[@class='thumbdesclist']//a[@id='calculatetest'])[1]"));
        calculater.click();

        MyFunc.Bekle(2);
        WebElement input1= driver.findElement(By.xpath("//div[@class='centered']//input[@id='number1']"));
        input1.sendKeys("20");

        MyFunc.Bekle(2);
        WebElement input2=driver.findElement(By.xpath("//div[@class='centered']//input[@id='number2']"));
        input2.sendKeys("25");

        MyFunc.Bekle(2);
        WebElement calculatorButton= driver.findElement(By.xpath("//div[@class='centered']//input[@id='calculate']"));
        calculatorButton.click();

        MyFunc.Bekle(2);
        WebElement total= driver.findElement(By.xpath("//div[@class='centered']//span[@id='answer']"));

        System.out.println("Total is = " + total.getText());

        BekleKapat();
    }
}
