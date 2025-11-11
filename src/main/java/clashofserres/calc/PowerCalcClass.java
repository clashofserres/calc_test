package clashofserres.calc;

public class PowerCalcClass implements IBaseCalcClass
{

    @Override
    public double calculate(double a, double b)
    {

        return Math.pow(a, b);
    }
}