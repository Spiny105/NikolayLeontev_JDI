package lesson_jdi.forms;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.complex.Menu;
import lesson_jdi.enums.HeaderItems;
import org.openqa.selenium.support.FindBy;


public class HeaderItemsSection extends Section {

    @FindBy(css = ".m-l8")
    private Menu menu;

    public void clickOnItem(HeaderItems item) {
        menu.select(item.getItem().toUpperCase());
    }
}