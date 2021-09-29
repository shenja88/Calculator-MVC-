package by.voluevich.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class MathOperation {
    private double numOne;
    private double numTwo;
    private String type;
    private double result;
    private User user;

    public MathOperation(double numOne, double numTwo, String type) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.type = type;
    }
}
