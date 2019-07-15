package lesson_jdi.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users extends DataClass<Users> {

    private String login;
    private String password;
    private String fullName;
}
