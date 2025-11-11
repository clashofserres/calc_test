package clashofserres.calc;

public class SquareCalcClass implements IBaseCalcClass
{


    @Override
    public double calculate(double a, double b)
    {

        if (a < 0) {

            return Double.NaN;
        }

        return Math.sqrt(a);
    }
}