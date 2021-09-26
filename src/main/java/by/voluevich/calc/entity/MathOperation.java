package by.voluevich.calc.entity;

import by.voluevich.calc.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class MathOperation {

    @Max(9223372036854775807L)
    private double numOne;

    @Max(9223372036854775807L)
    private double numTwo;

    @NotBlank(message = ErrorMessageManager.TYPE_OPERATION_ERROR)
    @NotEmpty(message = ErrorMessageManager.TYPE_OPERATION_ERROR)
    private String type;
    private double result;
    private User user;
}
