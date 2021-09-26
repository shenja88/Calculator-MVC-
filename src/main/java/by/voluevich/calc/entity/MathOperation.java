package by.voluevich.calc.entity;

import by.voluevich.calc.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class MathOperation {

    @NotBlank(message = ErrorMessageManager.NUMBER_ERROR)
    @Max(9223372036854775807L)
    @Pattern(regexp = "^[0-9]*[.,]?[0-9]{1,5}$", message = ErrorMessageManager.NUMBER_ERROR)
    private double numOne;

    @NotBlank(message = ErrorMessageManager.NUMBER_ERROR)
    @Max(9223372036854775807L)
    @Pattern(regexp = "^[0-9]*[.,]?[0-9]{1,5}$", message = ErrorMessageManager.NUMBER_ERROR)
    private double numTwo;

    @NotBlank(message = ErrorMessageManager.TYPE_OPERATION_ERROR)
    @NotEmpty(message = ErrorMessageManager.TYPE_OPERATION_ERROR)
    private String type;
    private double result;
    private User user;
}
