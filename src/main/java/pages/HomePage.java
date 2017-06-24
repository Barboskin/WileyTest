package pages;

import blocks.ResourcesList;
import blocks.SignUpBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


/**
 * Created by Женя on 23.06.2017.
 */
public class HomePage extends AbstractWileyPage {

    private ResourcesList resourcesList;
    private SignUpBlock signUpBlock;

    public HomePage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public ResourcesList getResourcesList() {
        return resourcesList;
    }

    public SignUpBlock getSignUpBlock() {
        return signUpBlock;
    }
}
