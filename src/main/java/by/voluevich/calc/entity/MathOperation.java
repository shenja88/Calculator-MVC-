package by.voluevich.calc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MathOperation {
    private double numOne;
    private double numTwo;
    private String type;
    private double result;
    private User user;
}
