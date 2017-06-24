package blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import utils.ListHelper;

import java.util.List;

/**
 * Created by Женя on 23.06.2017.
 */
@Name("Список_ресурсов")
@FindBy(xpath = "//div[@id = 'homepage-resources']")
public class ResourcesList extends HtmlElement {

    @Name("Список_ресурслв")
    @FindBy(xpath = ".//li")
    private List<Button> listResourcesButton;

    public int getCountItem(){
        return listResourcesButton.size();
    }

    public boolean checkTitles(List<String> exceptedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listResourcesButton);

        boolean flag = ListHelper.compareListStringByContent(actualList, exceptedList);
        return flag;
    }

    public void clickItem(String itemText){
        TypifiedElement item = ListHelper.getTypifiedElementByText(listResourcesButton, itemText);
        item.click();
    }

}
