package clashofserres.calc;

public class SquareCalcClass implements IBaseCalcClass
{

    @Override
    public double calculate(double a, double b) throws ArithmeticException
    {

        if (a < 0) {

            throw new ArithmeticException("Cannot calculate square root of a negative number.");
        }

        return Math.sqrt(a);
    }
}