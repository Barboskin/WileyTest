package blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by Женя on 24.06.2017.
 */
@FindBy(xpath = "//div[contains(@class, 'product-listing')]")
public class SearchResultItem extends HtmlElement {

    @Name("Название")
    @FindBy(xpath = ".//div[@class = 'product-title']/a")
    private Button nameButton;

    public String clickOnName(){
        String name = nameButton.getText();
        nameButton.click();
        return name;
    }
}
