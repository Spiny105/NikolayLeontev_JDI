package lesson_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.forms.MetalsAndColorsDifferentElementsForm;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

@Url("metals-and-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsDifferentElementsForm differentElementsForm;

    @FindBy(xpath = "//*[@id='mCSB_2_container']/section[2]//li")
    private List<WebElement> logRecords;

    public void submitData(MetalsAndColorsInput input) {
        differentElementsForm.submitData(input);
    }

    public void assertResultSection(MetalsAndColorsInput input) {

        List<String> stringRecods = logRecords.stream().map(x -> x.getText()).collect(Collectors.toList());
        Integer sum = input.getSummary().get(0) + input.getSummary().get(1);

        assertTrue(stringRecods.contains("Summary: " + sum.toString()));
        assertTrue(stringRecods.contains("Color: " + input.getColor()));
        assertTrue(stringRecods.contains("Metal: " + input.getMetals()));

        for (String vegetable : input.getVegetables()) {
            assertTrue(stringRecods.stream().filter(x -> x.contains(vegetable)).findFirst().orElse(null) != null);
        }
    }
}
