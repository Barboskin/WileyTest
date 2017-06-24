package blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Женя on 24.06.2017.
 */
@Name("Блок_регистрации")
@FindBy(xpath = "//div[@class ='compact homepage-sign-up-wrap']")
public class SignUpBlock extends HtmlElement {

    @Name("Email")
    @FindBy(xpath = ".//input[@id = 'EmailAddress']")
    private TextInput emailInput;

    @Name("Стрелка")
    @FindBy(xpath = ".//button[@value = 'Subscribe']")
    private Button nextButton;

    public void typeEmail(String email){
        emailInput.sendKeys(email);
    }

    public void clickNext(){
        nextButton.click();
    }
}
