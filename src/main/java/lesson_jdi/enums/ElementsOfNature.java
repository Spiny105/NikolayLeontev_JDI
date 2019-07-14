package lesson_jdi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ElementsOfNature {

    WATER("Water"),
    FIRE("Fire"),
    WIND("Wind"),
    EARTH("Earth");

    private final String item;

}
