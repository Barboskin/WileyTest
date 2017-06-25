package pages;

import blocks.ResourcesList;
import blocks.SignUpBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.logging.Logger;


/**
 * Created by Женя on 23.06.2017.
 */
public class HomePage extends AbstractWileyPage {

    private static Logger log = Logger.getLogger(HomePage.class.getName());

    private ResourcesList resourcesList;
    private SignUpBlock signUpBlock;

    public HomePage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        log.info(String.format("Загружена страница [%s]", HomePage.class.getName()));
    }

    public ResourcesList getResourcesList() {
        log.info(String.format("Получаем список ресурсов со страницы [%s]", HomePage.class.getName()));
        return resourcesList;
    }

    public SignUpBlock getSignUpBlock() {
        log.info(String.format("Получаем блок регистрации со страницы [%s]", HomePage.class.getName()));
        return signUpBlock;
    }
}
