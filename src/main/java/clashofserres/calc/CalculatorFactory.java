package clashofserres.calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating calculator operation instances.
 * Centralizes the mapping of operator strings to calculator classes.
 */
public class CalculatorFactory {
    
    private static final Map<String, Class<? extends IBaseCalcClass>> OPERATION_MAP = new HashMap<>();
    
    static {
        // Addition operations
        registerOperation("+", AddCalcClass.class);
        registerOperation("add", AddCalcClass.class);
        
        // Subtraction operations
        registerOperation("-", SubtractCalcClass.class);
        registerOperation("subtract", SubtractCalcClass.class);
        registerOperation("sub", SubtractCalcClass.class);
        
        // Multiplication operations
        registerOperation("*", MultCalcClass.class);
        registerOperation("x", MultCalcClass.class);
        registerOperation("mult", MultCalcClass.class);
        registerOperation("multiply", MultCalcClass.class);
        
        // Division operations
        registerOperation("/", DivCalcClass.class);
        registerOperation("div", DivCalcClass.class);
        registerOperation("divide", DivCalcClass.class);
        
        // Modulo operations
        registerOperation("%", ModCalcClass.class);
        registerOperation("mod", ModCalcClass.class);
        
        // Square root operations
        registerOperation("√", SquareCalcClass.class);
        registerOperation("sqrt", SquareCalcClass.class);
        
        // Power operations
        registerOperation("^", PowerCalcClass.class);
        registerOperation("pow", PowerCalcClass.class);
    }
    
    /**
     * Registers an operation string with its corresponding calculator class.
     * 
     * @param operation The operation string (e.g., "+", "add")
     * @param calcClass The calculator class that handles this operation
     */
    private static void registerOperation(String operation, Class<? extends IBaseCalcClass> calcClass) {
        OPERATION_MAP.put(operation.toLowerCase(), calcClass);
    }
    
    /**
     * Creates a calculator instance for the given operation.
     * 
     * @param operation The operation string (case-insensitive)
     * @return A calculator instance, or null if the operation is not recognized
     */
    public static IBaseCalcClass createCalculator(String operation) {
        if (operation == null || operation.isEmpty()) {
            return null;
        }
        
        Class<? extends IBaseCalcClass> calcClass = OPERATION_MAP.get(operation.toLowerCase());
        if (calcClass == null) {
            return null;
        }
        
        try {
            return calcClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create calculator instance for operation: " + operation, e);
        }
    }
    
    /**
     * Checks if the given operation is supported.
     * 
     * @param operation The operation string to check
     * @return true if the operation is supported, false otherwise
     */
    public static boolean isSupportedOperation(String operation) {
        return operation != null && OPERATION_MAP.containsKey(operation.toLowerCase());
    }
    
    /**
     * Gets all supported operation strings.
     * 
     * @return An array of all supported operation strings
     */
    public static String[] getSupportedOperations() {
        return OPERATION_MAP.keySet().toArray(new String[0]);
    }
}