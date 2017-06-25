package pages;

import blocks.SearchResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import utils.ListHelper;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Женя on 24.06.2017.
 */
public class SearchPage extends AbstractWileyPage {

    private static Logger log = Logger.getLogger(SearchPage.class.getName());

    @Name("Список_результатов_поиска")
    private List<SearchResultItem> listResultItems;

    public SearchPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        log.info(String.format("Загружена страница [%s]", SearchPage.class.getName()));
    }

    public String clickOnRandomResultItem(){
        log.info(String.format("Выполняем нажатие на случайный элемент списка результатов поиска"));
        int size = listResultItems.size();
        log.info(String.format("Генерируем случайное число"));
        int number = (int) (Math.random() * size);
        log.info(String.format("Сгенерировано число [%d]", number));
        SearchResultItem randomItem = listResultItems.get(number);
        log.info(String.format("Выполняем нажатие на [%d] элемент списка результатов поиска", number));
        return randomItem.clickOnName();
    }

    public boolean checkListResultsIsEmpty(){
        log.info(String.format("Проверяем наличие списка результатов поиска"));
        boolean flag = ListHelper.isEmpty(listResultItems);
        return flag;
    }
}
