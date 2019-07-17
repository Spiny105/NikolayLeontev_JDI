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
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;
}