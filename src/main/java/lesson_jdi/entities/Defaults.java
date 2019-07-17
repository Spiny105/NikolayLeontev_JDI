package lesson_jdi.entities;

import java.util.Arrays;

public class Defaults {

    public static final MetalsAndColorsInput METAL_AND_COLORS_DEFAULT_INPUT = new MetalsAndColorsInput().set(x -> {
        x.setColor("Red");
        x.setMetals("Selen");
        x.setVegetables(Arrays.asList("Cucumber", "Tomato"));
        x.setElements(Arrays.asList("Water", "Fire"));
        x.setSummary(Arrays.asList(3, 8));
    });

    public static final Users DEFAULT_USER = new Users().set(x -> {
                x.setFullName("PITER CHAILOVSKII");
                x.setLogin("epam");
                x.setPassword("1234");
            }
    );
}
