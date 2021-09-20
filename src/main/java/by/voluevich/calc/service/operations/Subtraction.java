package by.voluevich.calc.service.operations;

public class Subtraction implements Operation {

    @Override
    public int calculate(int a, int b) {
        return Math.subtractExact(a, b);
    }
}
