package lesson_jdi.entities;

import lesson_jdi.enums.Colors;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Metals;
import lesson_jdi.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum MetalsAndColorsInput {

    TESTDATA1(3, 8, Arrays.asList(ElementsOfNature.WATER, ElementsOfNature.FIRE), Colors.RED,
            Metals.SELEN, Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO));

    private final Integer odd;
    private final Integer even;
    private List<ElementsOfNature> elementsOfNatures;

    private final Colors color;
    private final Metals metal;
    private final List<Vegetables> vegetables;

}