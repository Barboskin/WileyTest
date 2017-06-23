package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


/**
 * Created by Женя on 23.06.2017.
 */
public class HomePage {

    private TopNavigationMenu topNavigationMenu;

    public HomePage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public TopNavigationMenu getTopNavigationMenu() {
        return topNavigationMenu;
    }
}
