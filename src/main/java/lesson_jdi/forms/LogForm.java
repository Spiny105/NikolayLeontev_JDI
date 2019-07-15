package lesson_jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Label;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.enums.Colors;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Metals;
import lesson_jdi.enums.Vegetables;

// TODO This is not a form.
public class LogForm extends Form<MetalsAndColorsInput> {

    @FindBy(xpath = "//li[@class='summ-res']")
    private Label summaryRecord;

    @FindBy(xpath = "//li[@class='elem-res']")
    private Label elementsRecord;

    @FindBy(xpath = "//li[@class='col-res']")
    private Label colorRecord;

    @FindBy(xpath = "//li[@class='met-res']")
    private Label metalRecord;

    @FindBy(xpath = "//li[@class='sal-res']")
    private Label vegRecord;

    // TODO What is the reason of this methods ?
    public Label getSummaryRecord() {
        return summaryRecord;
    }

    public Label getElementsRecord() {
        return elementsRecord;
    }

    public Label getColorRecord() {
        return colorRecord;
    }

    public Label getMetalRecord() {
        return metalRecord;
    }

    public Label getVegetableRecord() {
        return vegRecord;
    }
}
