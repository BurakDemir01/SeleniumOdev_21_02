package Odev_01_css;

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

        WebElement calculator= driver.findElement(By.cssSelector("[id='calculatetest']"));
        calculator.click();
        MyFunc.Bekle(2);

        WebElement input1= driver.findElement(By.cssSelector("[class='centered'] [id='number1']"));
        input1.sendKeys("15");

        WebElement input2= driver.findElement(By.cssSelector("[class='centered'] [id='number2']"));
        input2.sendKeys("25");
        MyFunc.Bekle(2);

        WebElement calculateButton= driver.findElement(By.cssSelector("[class='centered'] [id='calculate']"));
        calculateButton.click();

        WebElement answer= driver.findElement(By.cssSelector("[class='centered'] [id='answer']"));
        answer.getText();

        System.out.println("Answer = " + answer.getText());

        BekleKapat();
    }
}
