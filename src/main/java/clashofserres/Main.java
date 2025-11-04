package clashofserres;

import java.util.Locale;
import java.util.Scanner;

import clashofserres.calc.IBaseCalcClass;
import clashofserres.calc.AddCalcClass;
import clashofserres.calc.SubtractCalcClass;
import clashofserres.calc.MultCalcClass;
import clashofserres.calc.DivCalcClass;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        System.out.print("Enter operation (add, subtract, mult, div or +, -, *, /): ");
        String op = scanner.next().toLowerCase();

        IBaseCalcClass calculator;

        switch (op)
        {
            case "add":
            case "+":
                calculator = new AddCalcClass();
                break;
            case "subtract":
            case "sub":
            case "-":
                calculator = new SubtractCalcClass();
                break;
            case "mult":
            case "multiply":
            case "*":
            case "x":
                calculator = new MultCalcClass();
                break;
            case "div":
            case "divide":
            case "/":
                calculator = new DivCalcClass();
                break;
            default:
                System.out.println("Unknown operation: " + op);
                scanner.close();
                return;
        }

        double result = calculator.calculate(a, b);
        System.out.println("Result: " + result);

        scanner.close();
    }
}