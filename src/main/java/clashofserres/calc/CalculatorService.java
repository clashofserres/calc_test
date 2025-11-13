package clashofserres.calc;

public class CalculatorService {
    
    public double performCalculation(String operation, double firstNumber, double secondNumber) {
        IBaseCalcClass calculator = CalculatorFactory.createCalculator(operation);
        if (calculator == null) {
            throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return calculator.calculate(firstNumber, secondNumber);
    }
    
    public boolean isValidOperation(String operation) {
        return CalculatorFactory.isSupportedOperation(operation);
    }
}
