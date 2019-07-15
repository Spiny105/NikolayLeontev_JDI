package lesson_jdi.entities;

import lesson_jdi.enums.Colors;
import lesson_jdi.enums.ElementsOfNature;
import lesson_jdi.enums.Metals;
import lesson_jdi.enums.Vegetables;

import java.util.Arrays;

public class Defaults {

    public static final MetalsAndColorsInput METAL_AND_COLORS_DEFAULT_INPUT = new MetalsAndColorsInput().set(x -> {
        x.setColor(Colors.RED);
        x.setMetal(Metals.SELEN);
        x.setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO));
        x.setElementsOfNatures(Arrays.asList(ElementsOfNature.WATER, ElementsOfNature.FIRE));
        x.setOdd(3);
        x.setEven(8);
    });

    public static final Users DEFAULT_USER = new Users().set(x -> {
                x.setFullName("PITER CHAILOVSKII");
                x.setLogin("epam");
                x.setPassword("1234");
            }
    );
}
