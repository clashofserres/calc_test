package clashofserres.ui.model;


import clashofserres.calc.*;

public class CalculatorModel {
    private double memory = 0;
    private double value = 0;
    private String operator = "";

    public void setOperator(String op) {
        operator = op;
        memory = value;
        value = 0;
    }

    public double calculate(double input) throws Exception {
        IBaseCalcClass calcClass = getCalcClass();
        if (calcClass != null) {
           // System.out.println("calcClass: " + calcClass.calculate(memory, value));
            return calcClass.calculate(memory, input);
        }
        return input;
    }
    private IBaseCalcClass getCalcClass() {
        switch (operator)
        {
            case "+": return new AddCalcClass();
            case "-": return new SubtractCalcClass();
            case "*": return new MultCalcClass();
            case "/": return new DivCalcClass();
            // TODO: √, % and ^ logic.
        }
        return null;
    }

    public void setValue(double v) { value = v; }
    public double getValue() { return value; }

    public void memoryAdd(double v) { memory += v; }
    public void memorySubtract(double v) { memory -= v; }
    public double memoryRecall() { return memory; }
    public void memoryClear() { memory = 0; }
}
