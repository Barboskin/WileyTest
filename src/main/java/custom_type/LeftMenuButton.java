package custom_type;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

/**
 * Created by Женя on 24.06.2017.
 */
public class LeftMenuButton extends TypifiedElement {

    private final String SELECTED_ATTR = "active";
    private final String CHILD = "./*[1]";
    private final String REF = "./a[1]";

    public LeftMenuButton(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public String getText() {
        WebElement child = this.findElement(By.xpath(CHILD));
        return child.getText();
    }

    @Override
    public boolean isSelected() {
        String attr = this.getAttribute("class");
        return attr.contains(SELECTED_ATTR);
    }

    public boolean isClickable(){
        List<WebElement> refs = this.findElements(By.xpath(REF));
        if (refs.size() == 0){
            return false;
        } else {
            return true;
        }
    }
}
