package by.voluevich.calc.service.operations;

public class Modulo implements Operation {

    @Override
    public double calculate(double a, double b) {
        return a % b;
    }

}
