package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.logging.Logger;


/**
 * Created by Женя on 24.06.2017.
 */
public class ProductPage extends AbstractWileyPage {

    private static Logger log = Logger.getLogger(ProductPage.class.getName());

    @Name("Заголовок_продукта")
    @FindBy(xpath = "//h1")
    private TextBlock nameOfProduct;

    public ProductPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        log.info(String.format("Загружена страница [%s]", ProductPage.class.getName()));
    }

    public boolean checkNameOfProduct(String expectedName){
        log.info(String.format("Получаем заголовок продукта со страницы [%s]", ProductPage.class.getName()));
        String actualName = nameOfProduct.getText();
        log.info(String.format("Проверяем значение заголовка продукта. Ожидаемое: [%s]. Актуальное: [%s]",
                expectedName, actualName));
        return actualName.equals(expectedName);
    }
}
