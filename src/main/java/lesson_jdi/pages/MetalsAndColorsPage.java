package lesson_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Vegetables;
import lesson_jdi.forms.LogForm;
import lesson_jdi.forms.MetalsAndColorsMainForm;
import org.hamcrest.Matchers;

@Url("metals-and-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    // TODO What do you mean by 'mainForm' ?
    private MetalsAndColorsMainForm mainForm;
    private LogForm logForm;

    public void selectSummaryNumbers(MetalsAndColorsInput input){
        mainForm.selectSummaryNumbers(input.getOdd(), input.getEven());
    }

    // TODO You break up one of the OOP rule.
    // All calls for mainForm should be encapsulate in it.
    public void submitData(MetalsAndColorsInput input){
        mainForm.selectSummaryNumbers(input.getOdd(), input.getEven());
        mainForm.clickOnElementsOfNature(input.getElementsOfNatures());
        mainForm.selectColor(input.getColor());
        mainForm.selectMetal(input.getMetal());
        mainForm.selectVegetables(input.getVegetables());
        mainForm.submit();
    }

    // TODO Same story line line 25
    public void assertResultSection(MetalsAndColorsInput input) {
        Integer sum = input.getOdd() + input.getEven();
        logForm.getSummaryRecord().shouldBe().text(Matchers.containsString(sum.toString()));
        logForm.getColorRecord().shouldBe().text(Matchers.containsString(input.getColor().getItem()));
        logForm.getMetalRecord().shouldBe().text(Matchers.containsString(input.getMetal().getItem()));
        for (Vegetables vegetable : input.getVegetables()){
            logForm.getVegetableRecord().shouldBe().text(Matchers.containsString(vegetable.getItem()));
        }
    }
}
