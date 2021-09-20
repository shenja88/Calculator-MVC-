package by.voluevich.calc.service.operations;

public class Multiplication implements Operation {

    @Override
    public int calculate(int a, int b) {
        return Math.multiplyExact(a, b);
    }
}
