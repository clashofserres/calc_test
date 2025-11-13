package clashofserres.ui.model;

import clashofserres.calc.IBaseCalcClass;
import clashofserres.calc.CalculatorFactory;

public class CalculatorModel {
    private double memory = 0;
    private double value = 0;
    private String operator = "";

    public void setOperator(String op) {
        operator = op;
        memory = value;
        value = 0;
    }

    public double calculate(double input) {
        IBaseCalcClass calcClass = CalculatorFactory.createCalculator(operator);
        if (calcClass != null) {
            return calcClass.calculate(memory, input);
        }
        return input;
    }

    public void setValue(double v) { value = v; }
    public double getValue() { return value; }

    public void memoryAdd(double v) { memory += v; }
    public void memorySubtract(double v) { memory -= v; }
    public double memoryRecall() { return memory; }
    public void memoryClear() { memory = 0; }
}
