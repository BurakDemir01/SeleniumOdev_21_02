package Odev_05_Wait_Scroll_Alert;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*
https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
1) “Add Element” butona basin
2) “Delete” butonu gorunur oluncaya kadar bekleyin
3) “Delete” butonunun gorunur oldugunu test edin
4) Delete butonuna basarak butonu silin
5) Delete butonunun gorunmedigini test edin
 */
public class Soru5 extends BaseDriver {
    @Test
    public void Test5(){
        // driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Actions driverAksiyon = new Actions(driver);
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElement.click();

        WebElement delete = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        Action aksiyon1 = driverAksiyon.moveToElement(delete).click().build();
        wait.until(ExpectedConditions.visibilityOf(delete));
        MyFunc.Bekle(2);

        Assert.assertTrue("Delete Görünmüyor", delete.isDisplayed());
        aksiyon1.perform();


        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));
        //deleteButtons adında bir List<WebElement> nesnesine
        // bu bulunan elementler atanıyor.
        // deleteButtons.size() metodu ile deleteButtons listesindeki eleman sayısı kontrol ediliyor.

        boolean isDeleteButtonVisible = deleteButtons.size() > 0;  // deleteButtons listesinin boyutunu kontrol eder.
        //  Eğer bu liste boş değilse (yani sayısı 0'dan büyükse), isDeleteButtonVisible
        //  değişkenine "true" atanır. Aksi halde (liste boşsa) "false" atanır.

        if (isDeleteButtonVisible) {
            System.out.println("Delete button is still visible.");
        } else {
            System.out.println("Delete button is successfully removed.");
        }
    }
}
