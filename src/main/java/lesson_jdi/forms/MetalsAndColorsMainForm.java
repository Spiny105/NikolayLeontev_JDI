package lesson_jdi.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.enums.Colors;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Metals;
import lesson_jdi.enums.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsAndColorsMainForm extends Form<MetalsAndColorsInput> {

    @FindBy(xpath = "//*[@id='elements-checklist']//label[contains(text(), '%s')]")
    private UIElement elementsOfNatureCheckboxes;

    @FindBy(xpath = "//*[@id='odds-selector']//label[contains(text(), '%s')]")
    private UIElement oddCheckboxes;

    @FindBy(xpath = "//*[@id='even-selector']//label[contains(text(), '%s')]")
    private UIElement evenCheckboxes;

    @FindBy(xpath = "//*[@id='colors']//a[contains(., '%s')]")
    private UIElement colorsDropdown;

    @FindBy(xpath = "//*[@id='metals']//a[contains(., '%s')]")
    private UIElement metalsDropdown;

    @FindBy(xpath = "//*[@id='vegetables']//a[contains(., '%s')]")
    private UIElement vegetablesDropdown;

    @FindBy(xpath = "//*[@id=\"submit-button\"]")
    private Button submit;

    public void clickOnElementsOfNature(List<ElementsOfNature> elements) {
        for (ElementsOfNature element : elements) {
            elementsOfNatureCheckboxes.select(element.getItem());
        }
    }

    public void selectSummaryNumbers(Integer odd, Integer even) {
        oddCheckboxes.select(odd.toString());
        evenCheckboxes.select(even.toString());
    }

    public void selectColor(Colors color) {
        driver().findElement(By.xpath("//*[@id='colors']//*[@class='caret']")).click();
        colorsDropdown.select(color.getItem());
    }

    public void selectMetal(Metals metal) {
        driver().findElement(By.xpath("//*[@id='metals']//*[@class='caret']")).click();
        metalsDropdown.select(metal.getItem());
    }

    public void selectVegetables(List<Vegetables> vegetables){
        driver().findElement(By.xpath("//*[@id='vegetables']//*[@class='caret']")).click();
        for (Vegetables vegetable : vegetables) {
            vegetablesDropdown.select(vegetable.getItem());
        }
    }

    @Override
    public void submit() {
        submit.click();
    }
}