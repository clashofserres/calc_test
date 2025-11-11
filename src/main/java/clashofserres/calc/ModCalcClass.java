package clashofserres.calc;

public class ModCalcClass implements IBaseCalcClass
{

    @Override
    public double calculate(double a, double b)
    {

        if (b == 0) {

            return Double.NaN;
        }

        return a % b;
    }
}