package lesson_jdi.entities;

import com.epam.jdi.tools.DataClass;
import lesson_jdi.enums.Colors;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Metals;
import lesson_jdi.enums.Vegetables;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalsAndColorsInput extends DataClass<MetalsAndColorsInput> {

    // TODO This enum doesn't following java code convention. (fixed)
    private Integer odd;
    private Integer even;
    private List<ElementsOfNature> elementsOfNatures;

    private Colors color;
    private Metals metal;
    private List<Vegetables> vegetables;

}