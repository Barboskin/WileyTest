package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


/**
 * Created by Женя on 24.06.2017.
 */
public class ProductPage extends AbstractWileyPage {

    @Name("Заголовок_продукта")
    @FindBy(xpath = "//h1")
    private TextBlock nameOfProduct;

    public ProductPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public boolean checkNameOfProduct(String exceptedName){
        String actualName = nameOfProduct.getText();
        return actualName.equals(exceptedName);
    }
}
