package by.voluevich.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class User {
    private String name;
    private String login;
    private String password;
}
