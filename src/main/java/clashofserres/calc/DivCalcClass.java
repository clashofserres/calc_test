package clashofserres.calc;
import clashofserres.calc.IBaseCalcClass;

public class DivCalcClass  implements IBaseCalcClass{
    @Override
    public double calculate(double a, double b)
    {
        if(b==0)
            throw new ArithmeticException("Division by zero is not allowed.");

        return a/b;
    }
}
