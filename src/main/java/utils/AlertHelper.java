package utils;

import org.junit.Assert;
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

    public static void checkAlert(Alert alert){
        Assert.assertNotEquals("Алерт не появился на текущей странице", null, alert);
    }

    public static String checkAlertText(Alert alert, String expected){
        log.info(String.format("Получем текст из алерта"));
        if (alert != null){
            String actual = alert.getText();;
            Assert.assertEquals("Текст алерта на текущей странице не соответствует ожидаемому",
                    expected, actual);
            return actual;
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
