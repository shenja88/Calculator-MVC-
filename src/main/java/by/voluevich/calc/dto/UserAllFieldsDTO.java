package by.voluevich.calc.dto;

import by.voluevich.calc.entity.User;
import by.voluevich.calc.utils.ErrorMessageManager;
import by.voluevich.calc.utils.Patterns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class UserAllFieldsDTO {
    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    @Size(min = 3, max = 30, message = ErrorMessageManager.NAME_USER_ERROR)
    private String name;

    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    @Size(min = 6, max = 100,  message = ErrorMessageManager.EMAIL_USER_ERROR)
    @Pattern(regexp = Patterns.EMAIL, message = ErrorMessageManager.EMAIL_USER_ERROR)
    private String email;

    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    @Pattern(regexp = Patterns.PASSWORD, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;

}
