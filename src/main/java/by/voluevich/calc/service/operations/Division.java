package by.voluevich.calc.service.operations;

import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {

    @Override
    public double calculate(double a, double b) {
        return a / b;
    }

}
