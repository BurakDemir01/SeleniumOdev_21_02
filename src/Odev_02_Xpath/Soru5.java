package Odev_02_Xpath;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;

public class Soru5 extends BaseDriver {
    @Test
    public void Test5(){
        /*
        Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        Fake Alerts' tıklayınız.
        Show Alert Box'a tıklayınız.
        Ok'a tıklayınız.
        Alert kapanmalıdır.
         */

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Bekle(2);

    }
}
