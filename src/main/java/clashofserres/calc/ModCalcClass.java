package clashofserres.calc;

public class ModCalcClass implements IBaseCalcClass
{

    @Override
    public double calculate(double a, double b) throws ArithmeticException
    {
        // ΕΛΕΓΧΟΣ ΓΙΑ ΔΙΑΙΡΕΣΗ ΜΕ ΤΟ ΜΗΔΕΝ
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed.");
        }

        return a % b;
    }
}