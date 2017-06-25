package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * Created by Женя on 24.06.2017.
 */
public class AlertHelper {

    private static Logger log = Logger.getLogger(AlertHelper.class.getName());

    public static Alert getAlert(WebDriver driver) {
        log.info(String.format("Получем алерт"));
        try {
            Alert alert = driver.switchTo().alert();
            return alert;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getAlertText(Alert alert){
        log.info(String.format("Получем текст из алерта"));
        if (alert != null){
            return alert.getText();
        } else {
            throw new RuntimeException("Невозможно получить текст алерта");
        }
    }

    public static void confirmAlert(Alert alert){
        log.info(String.format("Принимаем алерт"));
        if (alert != null){
            alert.accept();
        } else {
            throw new RuntimeException("Невозможно принять алерт");
        }
    }
}
