package lesson_jdi.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import lesson_jdi.entities.MetalsAndColorsInput;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsAndColorsDifferentElementsForm extends Form<MetalsAndColorsInput> {

    @FindBy(xpath = "//*[@id='elements-checklist']//label[contains(text(), '%s')]")
    private UIElement elementsOfNatureCheckboxes;

    @FindBy(xpath = "//*[@id='odds-selector']//label[contains(text(), '%s')]")
    private RadioButtons oddRadios;

    @FindBy(xpath = "//*[@id='even-selector']//label[contains(text(), '%s')]")
    private RadioButtons evenRadios;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist colorsDroplist;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metalsDroplist;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist vegetablesDroplist;

    @FindBy(xpath = "//*[@id=\"submit-button\"]")
    private Button submit;

    private void clickOnElementsOfNature(List<String> elements) {
        for (String element : elements) {
            elementsOfNatureCheckboxes.select(element);
        }
    }

    private void selectSummaryNumbers(Integer odd, Integer even) {
        oddRadios.select(odd.toString());
        evenRadios.select(even.toString());
    }

    private void selectColor(String color) {
        colorsDroplist.select(color);
    }

    private void selectMetal(String metal) {
        metalsDroplist.select(metal);
    }

    private void selectVegetables(List<String> vegetables) {
        for (String vegetable : vegetables) {
            vegetablesDroplist.select(vegetable);
        }
    }

    @Override
    public void submit() {
        submit.click();
    }

    public void submitData(MetalsAndColorsInput input) {
        selectSummaryNumbers(input.getSummary().get(0), input.getSummary().get(1));
        clickOnElementsOfNature(input.getElements());
        selectColor(input.getColor());
        selectMetal(input.getMetals());
        selectVegetables(input.getVegetables());
        submit();
    }
}