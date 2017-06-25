package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.logging.Logger;


/**
 * Created by Женя on 23.06.2017.
 */
public class StudentsPage extends AbstractWileyPage {

    private static Logger log = Logger.getLogger(StudentsPage.class.getName());

    public StudentsPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        log.info(String.format("Загружена страница [%s]", StudentsPage.class.getName()));
    }

}
