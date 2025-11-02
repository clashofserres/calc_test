package clashofserres.calc;
import clashofserres.calc.IBaseCalcClass;

public class AddCalcClass implements IBaseCalcClass
{
	@Override
	public double calculate(double a, double b)
	{
		return a + b;
	}
}
