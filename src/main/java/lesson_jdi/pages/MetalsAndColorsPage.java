package lesson_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.enums.Vegetables;
import lesson_jdi.forms.MetalsAndColorsDifferentElementsForm;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

// TODO There is no testng available here, compilation error. Take a look on POM file.
import static org.testng.Assert.assertTrue;

@Url("metals-and-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsDifferentElementsForm differentElementsForm;

    @FindBy(xpath = "//*[@id='mCSB_2_container']/section[2]//li")
    private List<WebElement> logRecords;

    // All calls for differentElementsForm should be encapsulate in it.
    public void submitData(MetalsAndColorsInput input) {
        differentElementsForm.submitData(input);
    }

    public void assertResultSection(MetalsAndColorsInput input) {

        List<String> stringRecods = logRecords.stream().map(x -> x.getText()).collect(Collectors.toList());
        Integer sum = input.getOdd() + input.getEven();

        assertTrue(stringRecods.contains("Summary: " + sum.toString()));
        assertTrue(stringRecods.contains("Color: " + input.getColor().getItem()));
        assertTrue(stringRecods.contains("Metal: " + input.getMetal().getItem()));

        for (Vegetables vegetable : input.getVegetables()) {
            assertTrue(stringRecods.stream().filter(x -> x.contains(vegetable.getItem())).findFirst().orElse(null) != null);
        }
    }
}
