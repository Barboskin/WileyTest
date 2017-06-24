package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * Created by Женя on 24.06.2017.
 */
public class AlertHelper {

    public static Alert getAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            return alert;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getAlertText(Alert alert){
        if (alert != null){
            return alert.getText();
        } else {
            throw new RuntimeException("Невозможно получить текст алерта, т.к. он не появился на странице");
        }
    }

    public static void confirmAlert(Alert alert){
        if (alert != null){
            alert.accept();
        } else {
            throw new RuntimeException("Невозможно принять алерт, т.к. он не появился на странице");
        }
    }
}
