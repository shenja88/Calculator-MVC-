package by.voluevich.calc.dto;

import by.voluevich.calc.entity.MathOperation;
import by.voluevich.calc.entity.User;
import by.voluevich.calc.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MathOperationDTO {

    private double numOne;
    private double numTwo;

    @NotBlank(message = ErrorMessageManager.TYPE_OPERATION_ERROR)
    @NotEmpty(message = ErrorMessageManager.TYPE_OPERATION_ERROR)
    private String type;
    private double result;
    private User user;

    public MathOperation getMathOperation(){
        return new MathOperation(numOne, numTwo, type);
    }
}
