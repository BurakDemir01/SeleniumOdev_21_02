package Odev_02_Xpath;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;

public class Soru6 extends BaseDriver {
    @Test
    public void Test6(){
        /*
        Bu siteye gidiniz. https://testpages.herokuapp.com/styled/index.html
        Fake Alerts'e tıklayınız.
        Show modal dialog buttonuna tıklayınız.
        Ok'a tıklayınız.
        Alert kapanmalıdır.
         */

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Bekle(2);

    }
}
