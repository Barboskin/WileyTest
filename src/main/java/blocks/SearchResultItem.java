package blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.logging.Logger;

/**
 * Created by Женя on 24.06.2017.
 */
@FindBy(xpath = "//div[contains(@class, 'product-listing')]")
public class SearchResultItem extends HtmlElement {

    private static Logger log = Logger.getLogger(SearchResultItem.class.getName());

    @Name("Название")
    @FindBy(xpath = ".//div[@class = 'product-title']/a")
    private Button nameButton;

    public String clickOnName(){
        String name = nameButton.getText();
        log.info(String.format("Выполняем нажатием на элемент результатов поиска с заголовком [%s]", name));
        nameButton.click();
        return name;
    }
}
