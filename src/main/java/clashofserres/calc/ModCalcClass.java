package clashofserres.calc;

public class ModCalcClass implements IBaseCalcClass {
    private static final double EPSILON = 1e-10;
    
    @Override
    public double calculate(double a, double b) {
        if (Math.abs(b) < EPSILON) {
            throw new ArithmeticException("Modulo by zero is not allowed.");
        }
        return a % b;
    }
}