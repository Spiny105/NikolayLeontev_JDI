package lesson_jdi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Metals {

    GOLD("Gold"),
    SILVER("Silver"),
    SELEN("Selen"),
    BRONZE("Bronze");

    private final String item;

}
