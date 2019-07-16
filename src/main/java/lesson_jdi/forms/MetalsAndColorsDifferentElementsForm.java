package lesson_jdi.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.enums.Colors;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Metals;
import lesson_jdi.enums.Vegetables;
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

    private void clickOnElementsOfNature(List<ElementsOfNature> elements) {
        for (ElementsOfNature element : elements) {
            elementsOfNatureCheckboxes.select(element.getItem());
        }
    }

    private void selectSummaryNumbers(Integer odd, Integer even) {
        oddRadios.select(odd.toString());
        evenRadios.select(even.toString());
    }

    private void selectColor(Colors color) {
        colorsDroplist.select(color.getItem());
    }

    private void selectMetal(Metals metal) {
        metalsDroplist.select(metal.getItem());
    }

    private void selectVegetables(List<Vegetables> vegetables) {
        for (Vegetables vegetable : vegetables) {
            vegetablesDroplist.select(vegetable.getItem());
        }
    }

    @Override
    public void submit() {
        submit.click();
    }

    public void submitData(MetalsAndColorsInput input) {
        selectSummaryNumbers(input.getOdd(), input.getEven());
        clickOnElementsOfNature(input.getElementsOfNatures());
        selectColor(input.getColor());
        selectMetal(input.getMetal());
        selectVegetables(input.getVegetables());
        submit();
    }
}