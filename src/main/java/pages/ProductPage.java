package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.logging.Logger;


/**
 * Created by Женя on 24.06.2017.
 */
public class ProductPage extends AbstractWileyPage {

    private static Logger log = Logger.getLogger(ProductPage.class.getName());

    public ProductPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        log.info(String.format("Загружена страница [%s]", ProductPage.class.getName()));
    }
}
