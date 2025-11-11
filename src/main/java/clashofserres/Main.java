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
        if (args.length > 0 && args[0].equalsIgnoreCase("-NoUI")) {

            System.out.println("Running in command-line mode...");
        }
        else
        {
            CalculatorUI.launchUI(args);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);


        // Αυτή η μεταβλητή θα κρατάει το αποτέλεσμα της τελευταίας πράξης.
        double current_result = 0.0;

        // Μια βοηθητική μεταβλητή για να ξέρουμε αν είναι η πρώτη πράξη
        boolean isFirstOperation = true;

        System.out.println("Calculator is ON. Type 'C' to clear or 'exit' to quit.");

        // Ο υπολογιστής τρέχει τώρα σε ένα συνεχές loop
        while (true)
        {
            double a; // Ο πρώτος τελεστής

            // Αν δεν είναι η πρώτη πράξη, ο πρώτος αριθμός (a)
            // Αλλιώς είναι *αυτόματα* το προηγούμενο αποτέλεσμα.
            if (isFirstOperation) {
                System.out.print("Enter first number: ");
                a = scanner.nextDouble();
            } else {
                a = current_result;
                System.out.println("First number (from last result): " + a);
            }

            System.out.print("Enter operation (+, -, *, /) or 'C' (Clear) or 'exit':");
            String op = scanner.next().toLowerCase();

            // Αν δοθεί exit σταματάει τη λούπα.
            if (op.equals("exit")) {
                break;
            }
            // Αν δοθεί c κάνει clear το προηγούμενο αποτέλεσμα και ξεκινάει απο την αρχή
            if (op.equals("c")) {
                isFirstOperation = true;
                current_result = 0.0;
                System.out.println("--- Calculator Cleared ---");
                continue;
            }

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
                    continue;
            }

            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();


            current_result = calculator.calculate(a, b);

            // Μετά την πρώτη επιτυχημένη πράξη, το 'isFirstOperation' είναι πάντα false
            isFirstOperation = false;

            System.out.println("Result: " + current_result);
            System.out.println("--------------------");
        }

        System.out.println("Calculator OFF.");
        scanner.close();
    }
}