package lesson_jdi.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import lesson_jdi.entities.Users;
import lesson_jdi.enums.HeaderItems;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

// TODO What is the reason of 'extends Form<Users>' here ?
public class HeaderItemsForm extends Form<Users> {

    // TODO This locator can be simplified.
    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']")
    private UIElement menu;

    public void clickOnItem(HeaderItems item) {
        menu.find(By.xpath("//a[contains(text(), '" + item.getItem() + "')]")).click();
    }
}

