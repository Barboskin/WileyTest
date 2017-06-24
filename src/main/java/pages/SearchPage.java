package pages;

import blocks.SearchResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by Женя on 24.06.2017.
 */
public class SearchPage extends AbstractWileyPage {

    @Name("Список_результатов_поиска")
    private List<SearchResultItem> listResultItems;

    public SearchPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public List<SearchResultItem> getListResultItems() {
        return listResultItems;
    }

    public String clickOnRandomResultItem(){
        int size = listResultItems.size();
        int number = (int) (Math.random() * size);
        SearchResultItem randomItem = listResultItems.get(number);
        return randomItem.clickOnName();
    }
}
