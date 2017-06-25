package blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import utils.ListHelper;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Женя on 23.06.2017.
 */
@Name("Список_ресурсов")
@FindBy(xpath = "//div[@id = 'homepage-resources']")
public class ResourcesList extends HtmlElement {

    private static Logger log = Logger.getLogger(ResourcesList.class.getName());

    @Name("Список_ресурслв")
    @FindBy(xpath = ".//li")
    private List<Button> listResourcesButton;

    public int getCountItem(){
        log.info(String.format("Получаем количество элементов списка ресурсов"));
        return listResourcesButton.size();
    }

    public boolean checkTitles(List<String> expectedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listResourcesButton);
        log.info(String.format("Проверяем значения списка ресурсов. Ожидаемые: [%s]. Актуальные: [%s]",
                expectedList.toString(), actualList.toString()));
        boolean flag = ListHelper.compareListStringByContent(actualList, expectedList);
        return flag;
    }

    public void clickItem(String itemText){
        log.info(String.format("Выполняем нажатие на элемент с текстом [%s] из списка ресурсов",
                itemText));
        TypifiedElement item = ListHelper.getTypifiedElementByText(listResourcesButton, itemText);
        item.click();
    }

}
